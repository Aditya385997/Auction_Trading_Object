package com.example.freelance.freelanceproject.service;

import com.example.freelance.freelanceproject.Payload.VendorPayload;
import com.example.freelance.freelanceproject.model.Vendor;
import com.example.freelance.freelanceproject.repo.VendorRepo;
import com.sun.jdi.event.ExceptionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorService {

    private  final VendorRepo vendorRepo;
    @Autowired
    public VendorService(VendorRepo vendorRepo){
        this.vendorRepo = vendorRepo;
    }

    public boolean insertVendor(Vendor vendor)
    {
        try {
            vendorRepo.save(vendor);
            return true;
        }catch (Exception e)
        {
            System.err.print(e);
        }
        return false;

    }

    public Vendor getVendor(int id)
    {
        return vendorRepo.getReferenceById(id);
    }

}
