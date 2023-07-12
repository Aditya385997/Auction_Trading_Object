package com.example.freelance.freelanceproject.response;

import java.time.LocalDateTime;

public class PriceDto {

    private String vendorName;
    private String instrumentName;
    private double amount;
    private LocalDateTime timestamp;

    public PriceDto() {
    }

    public PriceDto(String vendorName, String instrumentName, double amount, LocalDateTime timestamp) {
        this.vendorName = vendorName;
        this.instrumentName = instrumentName;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrumentName(String instrumentName) {
        this.instrumentName = instrumentName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
