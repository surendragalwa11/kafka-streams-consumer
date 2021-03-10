package com.kafka.stream.consumer.Configuration;

import com.kafka.stream.consumer.Service.KafkaStreamConsumerServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaStreamConsumerServiceConfiguration {

    String serviceNameConfig = "someConfiguration";

    @Bean
    public KafkaStreamConsumerServices kafkaStreamConsumerServices() {
        return new KafkaStreamConsumerServices(serviceNameConfig);
    }
}
