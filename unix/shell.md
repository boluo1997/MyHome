# MyHome


##### 启动 docker
```shell
sudo systemctl start docker
```

##### 关闭 docker
```shell
sudo systemctl stop docker
```

##### 重启 docker
```shell
sudo systemctl restart docker
```

##### docker 安装容器
```shell
docker pull wurstmeister/kafka
```

##### 查看 docker 镜像列表
```shell
docker images
```

##### docker 查看容器
```shell
docker ps -a
```

##### docker 停止容器
```shell
docker stop <id>
```

##### docker 启动已停止的容器
```shell
docker start <id>
```

##### docker 删除容器
```shell
docker rm <id>
```

##### docker sh进入容器
```shell
docker exec -it <id> /bin/bash
```


```shell
docker run -d --name zookeeper -p 2181:2181 -t wurstmeister/zookeeper
```


##### docker 启动 kafka
```shell
docker run -d --name kafka -p 9092:9092 \
--link zookeeper:zookeeper \
--env KAFKA_ZOOKEEPER_CONNECT=zookeeper:2181 \
--env KAFKA_ADVERTISED_HOST_NAME=localhost \
--env KAFKA_ADVERTISED_PORT=9092  \
--env KAFKA_LOG_DIRS=/kafka/logs \
-v kafka_vol:/kafka  \
wurstmeister/kafka


# 这个是可以成功启动的 2025年1月25日
docker run -d --name kafka \
-p 9092:9092 \
-e KAFKA_BROKER_ID=0 \
-e KAFKA_ZOOKEEPER_CONNECT=118.178.253.61:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://118.178.253.61:9092 \
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 wurstmeister/kafka



```









##### 对应问题 1
```text
报错情况:
本机 Windows上 telnet 118.178.253.61 9092 失败!
在阿里云界面添加防火墙规则: 添加 TCP / 9092 / windows ip
问题解决
```


##### 对应问题 2
```text
报错情况:
虚拟机上服务器使用生产者和消费者可以发布消费消息，但是Windows本机生产消费报错!!!

解决方案:
设置kafka配置文件中的advertised.listeners属性！注意，该属性才是对应外网的监听属性！修改后：

进入方式:
docker exec -it <container_id> /bin/bash
vim /opt/kafka/config/server.properties

# 允许外部端口连接
listeners=PLAINTEXT://:9092
# 外部代理地址docker
advertised.listeners=PLAINTEXT://118.178.253.61:9092

192.168.130.130是我虚拟机服务器自己的地址，可使用ifconfig命令查看
同时, 本地java程序生产者设置的bootstrap.servers对应值也改为 118.178.253.61:9092

然后重启 docker kafka, 问题解决
```