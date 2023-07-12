package com.example.freelance.freelanceproject.Payload;

import java.time.LocalDateTime;

public class PricePayload {
    private double amount;
    private LocalDateTime timestamp;

    //Api should be created to Create
    private int vendor_id;
    private int instrument_id;

    public PricePayload() {
    }

    public PricePayload(double amount, int vendor_id, int instrument_id) {
        this.amount = amount;
        this.vendor_id = vendor_id;
        this.instrument_id = instrument_id;
    }

    public PricePayload(double amount, LocalDateTime timestamp, int vendor_id, int instrument_id) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.vendor_id = vendor_id;
        this.instrument_id = instrument_id;
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

    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    @Override
    public String toString() {
        return "PricePayload{" +
                "amount=" + amount +
                ", timestamp=" + timestamp +
                ", vendor_id=" + vendor_id +
                ", instrument_id=" + instrument_id +
                '}';
    }
}
