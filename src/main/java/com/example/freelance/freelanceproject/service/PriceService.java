package com.example.freelance.freelanceproject.service;

import com.example.freelance.freelanceproject.kafka.KafkaProducer;
import com.example.freelance.freelanceproject.model.Instrument;
import com.example.freelance.freelanceproject.model.Price;
import com.example.freelance.freelanceproject.repo.PriceRepo;
import com.example.freelance.freelanceproject.response.PriceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PriceService {

    private final PriceRepo pricerepo;
    private final KafkaProducer kafkaProducer;
    @Autowired
    public PriceService(PriceRepo pricerepo,KafkaProducer kafkaProducer) {
        this.pricerepo = pricerepo;
        this.kafkaProducer = kafkaProducer;
    }




    public void insertPrice(Price price)
    {
        pricerepo.save(price);
    }
    public List<PriceDto> getPriceByInstrumentId(int instrument_id)
    {

        List<PriceDto> responseData = new ArrayList<>();
        List<Price> prices = pricerepo.findByInstrumentId(instrument_id);
        for (Price price:prices)
        {
            PriceDto priceDto = new PriceDto();
            priceDto.setVendorName(price.getVendor().getVendor_name());
            priceDto.setAmount(price.getAmount());
            priceDto.setInstrumentName(price.getInstrument().getInstrument_name());
            priceDto.setTimestamp(price.getTimestamp());
            responseData.add(priceDto);
            kafkaProducer.sendMssg(priceDto);
        }
        System.out.print(responseData);
         return responseData;
    }



//    public void pushPriceToKafka(PriceDto price)
//    {
//        try{
//            kafkaProducer.sendMssg(price);
//
//        }catch (Exception e)
//        {
//            System.out.print(e);
//
//        }
//
//
//    }
}
