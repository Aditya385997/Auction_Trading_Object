package com.example.freelance.freelanceproject.repo;

import com.example.freelance.freelanceproject.model.Price;
import com.example.freelance.freelanceproject.response.PriceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface PriceRepo extends JpaRepository<Price,Integer>{
     @Query("SELECT p FROM Price p WHERE p.instrument.instrument_id = :instrumentId")

    List<Price> findByInstrumentId(@Param("instrumentId") int instrumentId);
}
