package com.example.freelance.freelanceproject.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vendor_id;
    @Column(name = "vendor_name")
    private String vendor_name;

    @OneToMany(mappedBy = "vendor",cascade = CascadeType.ALL)
    @Transient
   private List<Price> price;

    public Vendor() {
    }

    public Vendor(int vendor_id, String vendor_name,List<Price> price) {
        this.vendor_id = vendor_id;
        this.vendor_name = vendor_name;
        this.price = price;
    }

    public void setPrice(List<Price> price)
    {
        this.price = price;
    }
    public List<Price> getPrice()
    {
        return price;
    }
    public int getVendor_id() {
        return vendor_id;
    }

    public void setVendor_id(int vendor_id) {
        this.vendor_id = vendor_id;
    }

    public String getVendor_name() {
        return vendor_name;
    }

    public void setVendor_name(String vendor_name) {
        this.vendor_name = vendor_name;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vendor_id='" + vendor_id + '\'' +
                ", vendor_name='" + vendor_name + '\'' +
                ", price=" + price +
                '}';
    }
}
