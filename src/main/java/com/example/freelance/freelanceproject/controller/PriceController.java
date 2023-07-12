package com.example.freelance.freelanceproject.controller;

import com.example.freelance.freelanceproject.Payload.PricePayload;
import com.example.freelance.freelanceproject.model.Instrument;
import com.example.freelance.freelanceproject.model.Price;
import com.example.freelance.freelanceproject.model.Vendor;
import com.example.freelance.freelanceproject.response.PriceDto;
import com.example.freelance.freelanceproject.service.InstrumentService;
import com.example.freelance.freelanceproject.service.PriceService;
import com.example.freelance.freelanceproject.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {
    private final InstrumentService instrumentService;
    private final VendorService vendorService;

    private final PriceService priceService;

    @Autowired
    public PriceController(InstrumentService instrumentService, VendorService vendorService, PriceService priceService) {
        this.instrumentService = instrumentService;
        this.vendorService = vendorService;
        this.priceService = priceService;
    }

    @PostMapping("/insertprice")
    public ResponseEntity<Price> insertPrice(@RequestBody PricePayload pricePayload)
    {
        Vendor vendor = vendorService.getVendor(pricePayload.getVendor_id());
        Instrument instrument = instrumentService.getInstrumentbyId(pricePayload.getInstrument_id());

        Price price = new Price();
        price.setAmount(pricePayload.getAmount());
        price.setVendor(vendor);
        price.setInstrument(instrument);
        price.setTimestamp(LocalDateTime.now());
        price.setVendor(vendor);
        price.setInstrument(instrument);
        priceService.insertPrice(price);
        return new ResponseEntity<>(HttpStatusCode.valueOf(200));
    }

    @GetMapping("/instruments/{instrument_id}")
    public ResponseEntity<List<PriceDto>> getPricesofInstrumentOfDifferentVendor(@PathVariable(name = "instrument_id") int instrument_id)
    {
        List<PriceDto> prices = priceService.getPriceByInstrumentId(instrument_id);


//        boolean success = priceService.pushPriceToKafka(prices);
        return new ResponseEntity<>(prices,HttpStatusCode.valueOf(200));
    }

}
