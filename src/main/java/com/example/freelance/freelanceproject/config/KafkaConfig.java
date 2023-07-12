package com.example.freelance.freelanceproject.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {

    //Topic Inside a Kafka Apache Broker and there by default partition build by kafka we can also configure the partitions
    @Bean
    public NewTopic priceData()
    {
        return TopicBuilder.name("InstrumentPriceDataFromDifferentVendor")
                .build();
    }

}
