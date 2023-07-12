package com.example.freelance.freelanceproject.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int price_id;
    @Column(name = "amount")
    private double amount;
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private LocalDateTime timestamp;

    @ManyToOne
            @JoinColumn(name = "instrument_id")
    private Instrument instrument;
    @ManyToOne
    @JoinColumn(name = "vendor_id")
    private Vendor vendor;

    public Price() {
    }


    public Price(int price_id, Instrument instrument, Vendor vendor,double amount,LocalDateTime timestamp) {
        this.price_id = price_id;
        this.instrument = instrument;
        this.vendor = vendor;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
    public LocalDateTime getTimestamp()
    {
        return timestamp;
    }

    public void setAmount(double price){
        this.amount = price;
    }
    public double getAmount()
    {
        return amount;
    }
    public int getPrice_id() {
        return price_id;
    }

    public void setPrice_id(int price_id) {
        this.price_id = price_id;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    @Override
    public String toString() {
        return "Price{" +
                "price_id='" + price_id + '\'' +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                ", instrument=" + instrument +
                ", vendor=" + vendor +
                '}';
    }
}
