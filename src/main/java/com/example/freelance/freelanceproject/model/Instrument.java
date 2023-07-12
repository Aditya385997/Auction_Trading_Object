package com.example.freelance.freelanceproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int instrument_id;
    @Column(name = "instrument_name")
    private String instrument_name;
    @OneToMany(mappedBy = "instrument",cascade = CascadeType.ALL)
    @Transient
    private List<Price> price;


    public Instrument() {
    }

    public Instrument(int instrument_id, String instrument_name,List<Price> price) {
        this.instrument_id = instrument_id;
        this.instrument_name = instrument_name;
        this.price = price;
    }
    public void  setPrice(List<Price> price)
    {
        this.price = price;
    }
    public List<Price> getPrice()
    {
        return price;
    }

    public int getInstrument_id() {
        return instrument_id;
    }

    public void setInstrument_id(int instrument_id) {
        this.instrument_id = instrument_id;
    }

    public String getInstrument_name() {
        return instrument_name;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrument_name = instrument_name;
    }

    @Override
    public String toString() {
        return "Instrument{" +
                "instrument_id=" + instrument_id +
                ", instrument_name='" + instrument_name + '\'' +
                ", price=" + price +
                '}';
    }
}
