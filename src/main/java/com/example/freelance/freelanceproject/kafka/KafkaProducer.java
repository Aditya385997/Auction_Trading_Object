package com.example.freelance.freelanceproject.kafka;

import com.example.freelance.freelanceproject.model.Instrument;
import com.example.freelance.freelanceproject.model.Price;
import com.example.freelance.freelanceproject.response.PriceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    private final KafkaTemplate<String, Price> kafkaTemplate;

    @Autowired
    public KafkaProducer(KafkaTemplate<String, Price> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMssg(PriceDto data)
    {
        logger.info(String.format("Message Sent -> %s",data.toString()));
        Message<PriceDto> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"InstrumentPriceDataFromDifferentVendor")
                .build();
        kafkaTemplate.send(message);

    }
}
