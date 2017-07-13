package com.sc.ymfeed.mybatis.redis;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.log4j.Logger;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import com.sc.ymfeed.common.util.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;

public class RedisCache implements Cache {

	private static Logger logger = Logger.getLogger(RedisCache.class);

	private static final boolean USER_REDIS = false;

	private static final boolean IS_CLUSTER_CACHE = true;

	private static JedisConnectionFactory jedisConnectionFactory;
	private JedisCluster jedisCluster;
	private Jedis jedis;
	private Set<String> keys = new HashSet<String>();

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock(); // 读写锁

	private String id;

	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
		logger.debug(">>>>>>>>RedisCache:id=" + id);
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

	@Override
	public int getSize() {
		if (!USER_REDIS) {
			return 0;
		}
		try {
			if (IS_CLUSTER_CACHE) {
				return keys.size();
			} else {
				return Integer.valueOf(getJedis().dbSize().toString());
			}
		} catch (Exception e) {
			jedisCluster = null;
			jedis = null;
			logger.error("redis get size error");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public void putObject(Object key, Object value) {
		if (!USER_REDIS) {
			return;
		}
		try {
			if (IS_CLUSTER_CACHE) {
				JedisCluster jc = getJedisCluster();
				if (jc != null) {
					jc.set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
					logger.debug(">>>>>>>>putObject:" + key + ",value=" + value);
				}
				if (!keys.contains(key.toString())) {
					keys.add(key.toString());
				}
			} else {
				getJedis().set(SerializeUtil.serialize(key.toString()), SerializeUtil.serialize(value));
			}
		} catch (Exception e) {
			jedisCluster = null;
			jedis = null;
			logger.error("redis put object error");
			e.printStackTrace();
		}
	}

	@Override
	public Object getObject(Object key) {
		if (!USER_REDIS) {
			return null;
		}
		byte[] bytes = null;
		try {
			if (IS_CLUSTER_CACHE) {
				JedisCluster jc = getJedisCluster();
				if (jc != null) {
					bytes = jc.get(SerializeUtil.serialize(key.toString()));
				}
				if (!keys.contains(key.toString())) {
					keys.add(key.toString());
				}
			} else {
				bytes = getJedis().get(SerializeUtil.serialize(key.toString()));
			}
		} catch (Exception e) {
			jedisCluster = null;
			jedis = null;
			logger.error("redis get object error");
			e.printStackTrace();
		}
		Object value = null;
		if (bytes != null) {
			value = SerializeUtil.unserialize(bytes);
			logger.debug(">>>>>>>>getObject:" + key + ",value=" + value);
		}
		return value;
	}

	@Override
	public Object removeObject(Object key) {
		if (!USER_REDIS) {
			return null;
		}
		try {
			if (IS_CLUSTER_CACHE) {
				keys.remove(key.toString());
				JedisCluster jc = getJedisCluster();
				if (jc != null) {
					return jc.expire(SerializeUtil.serialize(key.toString()), 0);
				}
			} else {
				return getJedis().expire(SerializeUtil.serialize(key.toString()), 0);
			}
		} catch (Exception e) {
			jedisCluster = null;
			jedis = null;
			logger.error("redis remove object error");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void clear() {
		if (!USER_REDIS) {
			return;
		}
		try {
			if (IS_CLUSTER_CACHE) {
				JedisCluster jc = getJedisCluster();
				if (jc != null) {
					for (String key : keys) {
						jc.expire(SerializeUtil.serialize(key.toString()), 0);
					}
				}
				keys.clear();
			} else {
				getJedis().flushDB();
			}
		} catch (Exception e) {
			jedisCluster = null;
			jedis = null;
			logger.error("redis clear error");
			e.printStackTrace();
		}
	}

	private Jedis getJedis() {
		if (jedis == null) {
			jedis = (Jedis) jedisConnectionFactory.getConnection().getNativeConnection();
		}
		return jedis;
	}

	private JedisCluster getJedisCluster() {
		if (jedisCluster == null) {
			jedisCluster = (JedisCluster) jedisConnectionFactory.getClusterConnection().getNativeConnection();
		}
		return jedisCluster;
	}

	public static void setJedisConnectionFactory(JedisConnectionFactory jedisConnectionFactory) {
		RedisCache.jedisConnectionFactory = jedisConnectionFactory;
	}

	// sql
	// <cache eviction="LRU" type="com.sc.ymfeed.mybatis.redis.RedisCache" />
}
