package com.example.freelance.freelanceproject.Payload;

public class VendorPayload {

    private String vendorName;

    public VendorPayload()
    {

    }
    public VendorPayload(String vendorName)
    {
        this.vendorName = vendorName;
    }



    public String getVendorName() {
        return vendorName;
    }

    public void setVendor_name(String vendor_name) {
        this.vendorName = vendor_name;
    }

    @Override
    public String toString() {
        return "VendorPayload{" +
                ", vendorName='" + vendorName + '\'' +
                '}';
    }
}
