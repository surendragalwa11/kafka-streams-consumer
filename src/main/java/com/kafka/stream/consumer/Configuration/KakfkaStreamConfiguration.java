package com.kafka.stream.consumer.Configuration;

import com.google.common.collect.ImmutableMap;
import com.kafka.stream.consumer.Service.KafkaStreamConsumerServices;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class KakfkaStreamConfiguration {

    @Value("${spring.kafka.topic}")
    String topic = "test";

    @Bean(name= KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration defaultKafkaStreamsConfiguration(KafkaProperties kafkaProperties) {
        return new KafkaStreamsConfiguration(
                ImmutableMap.<String, Object>builder()
                .put(StreamsConfig.APPLICATION_ID_CONFIG, kafkaProperties.getStreams().getApplicationId())
                .put(StreamsConfig.CLIENT_ID_CONFIG, "kafka-streams-consumer")
                .put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers())
                .put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName())
                .put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName())
                .build()
        );
    }

    @Bean
    public KStream<String, String> kStream(
            KafkaStreamConsumerServices service,
            StreamsBuilder builder
    ) {
        KStream<String, String> streams = builder.stream(topic);
        streams.process(() -> new KafkaStreamConsumerServices("abc"));
        // streams.process(() -> service);
        return  streams;
    }
}
