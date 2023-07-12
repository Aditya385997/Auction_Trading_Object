package com.example.freelance.freelanceproject.repo;

import com.example.freelance.freelanceproject.Payload.VendorPayload;
import com.example.freelance.freelanceproject.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor,Integer> {
}
