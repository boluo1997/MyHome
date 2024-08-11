package com.boluo.kafka;

import org.apache.kafka.clients.producer.*;

import java.util.Properties;
import java.util.UUID;

/**
 * @author chao
 * @datetime 2024-05-31 22:32
 * @description
 */
public class MyProducer {

    private static Properties props = new Properties();
    private static String topicName;
    private static String bootstrapServers;

    static {
        topicName = "com.boluo.topic.first";
        bootstrapServers = "118.178.253.61:9092";

        props.put("bootstrap.servers", bootstrapServers);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    }

    public static void main(String[] args) {
        Producer<String, String> producer = new KafkaProducer<>(props);

        String key = UUID.randomUUID().toString();
        String value = "{\"a\": 123}";
        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);

        while (true) {
            producer.send(record, (metadata, e) -> {
                System.out.printf("数据已发送, topic: %s, partition: %d, offset:%s%n", metadata.topic(), metadata.partition(), metadata.offset());
            });
        }

    }

}
