#启动全部redis
cd 7000
redis-server redis.conf
cd ..
cd 7001
redis-server redis.conf
cd ..
cd 7002
redis-server redis.conf
cd ..
cd 7003
redis-server redis.conf
cd ..
cd 7004
redis-server redis.conf
cd ..
cd 7005
redis-server redis.conf
cd ..

#查看当前redis进程
ps aux|grep redis

#节点全部启动之后，创建集群，进入redis-3.2.9/src目录
#./redis-trib.rb create --replicas 1 127.0.0.1:7000 127.0.0.1:7001 127.0.0.1:7002 127.0.0.1:7003 127.0.0.1:7004 127.0.0.1:7005

####安装Ruby环境
#步骤1、安装RVM
#1、curl -L https://get.rvm.io | bash -s stable
#2、source ~/.rvm/scripts/rvm  新开 Termal 就不用这么做了，会自动重新载入的
#2、rvm -v  检查一下是否安装正确

#步骤2 － 用 RVM 安装 Ruby 环境
#1、rvm list known  列出已知的ruby版本
#2、rvm install 2.4  选择现有的rvm版本来进行安装
#3、rvm list  查询已经安装的ruby
#4、rvm remove 1.9.2  卸载一个已安装版本

#步骤3 － 设置 Ruby 版本
#1、rvm 2.4 --default  RVM 装好以后，需要执行下面的命令将指定版本的 Ruby 设置为系统默认版本
#2、ruby -v  测试是否正确
#3、gem -v

####安装ruby的redis接口
#sudo gem install redis