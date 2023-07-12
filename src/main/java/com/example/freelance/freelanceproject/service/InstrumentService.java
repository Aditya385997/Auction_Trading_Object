package com.example.freelance.freelanceproject.service;

import com.example.freelance.freelanceproject.model.Instrument;
import com.example.freelance.freelanceproject.repo.InstrumentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstrumentService {

    private final InstrumentRepo instrumentRepo;
    @Autowired
    public InstrumentService(InstrumentRepo instrumentRepo){
        this.instrumentRepo = instrumentRepo;
    }

    public boolean insertInstrument(Instrument instrument)
    {
        try{
            System.out.println(instrument);
            instrumentRepo.save(instrument);
            return true;
        }catch (Exception e){
            System.out.print(e);
        }
            return false;
    }

    public Instrument getInstrumentbyId(int id)
    {
        return instrumentRepo.getReferenceById(id);
    }
}
