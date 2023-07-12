package com.example.freelance.freelanceproject.repo;

import com.example.freelance.freelanceproject.model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface InstrumentRepo extends JpaRepository<Instrument,Integer>{

}
