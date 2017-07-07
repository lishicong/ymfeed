#集群启动关闭：
#!/bin/sh
/usr/local/redis-3.2.9/src/redis-cli -p 7000 shutdown
/usr/local/redis-3.2.9/src/redis-cli -p 7001 shutdown
/usr/local/redis-3.2.9/src/redis-cli -p 7002 shutdown
/usr/local/redis-3.2.9/src/redis-cli -p 7003 shutdown
/usr/local/redis-3.2.9/src/redis-cli -p 7004 shutdown
/usr/local/redis-3.2.9/src/redis-cli -p 7005 shutdown
if [ $(ps -ef | grep -c redis | grep -cv grep) -gt 1 ]
then echo "Cluster close failuer, check node please"
else
 echo "Cluster close all，ok"
fi