package com.example.freelance.freelanceproject.controller;

import com.example.freelance.freelanceproject.Payload.VendorPayload;
import com.example.freelance.freelanceproject.model.Vendor;
import com.example.freelance.freelanceproject.service.VendorService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendors")
public class VendorController {


    private final VendorService vendorService;
    @Autowired
    public VendorController(VendorService vendorService)
    {
        this.vendorService = vendorService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Vendor> insertVendor(@NotNull @RequestBody VendorPayload vendorPayload)
    {
        Vendor vendor = new Vendor();
        vendor.setVendor_name(vendorPayload.getVendorName());
        System.out.print(vendor);
        boolean status;
        status = vendorService.insertVendor(vendor);
        if(status)
            return new ResponseEntity<>(vendor,HttpStatusCode.valueOf(200));
        else
            return new ResponseEntity<>(vendor,HttpStatusCode.valueOf(404));
    }


}
