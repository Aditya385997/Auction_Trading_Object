package com.example.freelance.freelanceproject.Payload;

public class InstrumentPayload {

    private String instrumentName;

    public InstrumentPayload() {
    }

    public InstrumentPayload(String instrumentName) {

        this.instrumentName = instrumentName;
    }

    public String getInstrumentName() {
        return instrumentName;
    }

    public void setInstrument_name(String instrument_name) {
        this.instrumentName = instrumentName;
    }

    @Override
    public String toString() {
        return "InstrumentPayload{" +
                ", instrument_name='" + instrumentName + '\'' +
                '}';
    }
}
