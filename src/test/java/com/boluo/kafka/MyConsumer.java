package com.boluo.kafka;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.ConsumerRecord;

import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

/**
 * @author chao
 * @datetime 2024-05-31 22:08
 * @description
 */
public class MyConsumer {

    private static Properties props = new Properties();
    private static String topicName;
    private static String bootstrapServers;
    private static String groupId;
    private static boolean autoCommit;

    static {

        topicName = "com.boluo.topic.first";
        bootstrapServers = "118.178.253.61:9092";
        groupId = "com.boluo.group.first";
        autoCommit = false;

        props.put("bootstrap.servers", bootstrapServers);
        props.put("group.id", groupId);
        props.put("enable.auto.commit", autoCommit);
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
    }

    public static void main(String[] args) {

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Collections.singletonList("com.boluo.topic.first"));

        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(100);
            System.out.println("records is empty: " + records.isEmpty());
            for (ConsumerRecord<String, String> record : records) {
                System.out.printf("partition = %d, offset = %d, key = %s, value = %s%n", record.partition(), record.offset(), record.key(), record.value());
            }
        }

    }

}
