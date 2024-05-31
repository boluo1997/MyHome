# MyHome




##### docker 启动 kafka
```shell
docker run -d --name kafka \
-p 9092:9092 \
-e KAFKA_BROKER_ID=0 \
-e KAFKA_ZOOKEEPER_CONNECT=118.178.253.61:2181 \
-e KAFKA_ADVERTISED_LISTENERS=PLAINTEXT://118.178.253.61:9092 \
-e KAFKA_LISTENERS=PLAINTEXT://0.0.0.0:9092 wurstmeister/kafka
```