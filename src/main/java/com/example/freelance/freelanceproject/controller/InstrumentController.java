package com.example.freelance.freelanceproject.controller;

import com.example.freelance.freelanceproject.Payload.InstrumentPayload;
import com.example.freelance.freelanceproject.model.Instrument;
import com.example.freelance.freelanceproject.service.InstrumentService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/api/instruments/")
public class InstrumentController {

   private final InstrumentService instrumentService;
   @Autowired
   public InstrumentController(InstrumentService instrumentService)
   {
       this.instrumentService = instrumentService;
   }

   @PostMapping("insert")
   public ResponseEntity<Instrument> insert(@NotNull @RequestBody  InstrumentPayload instrumentPayload)
   {
       Instrument instrument = new Instrument();
       instrument.setInstrument_name(instrumentPayload.getInstrumentName());
       boolean status;
       status = instrumentService.insertInstrument(instrument);
       if(status)
           return new ResponseEntity<>(instrument, HttpStatus.OK);
       else
           return new ResponseEntity<>(instrument,HttpStatus.BAD_REQUEST);
   }



}
