package com.api.hotelSpring.repository;


import com.api.hotelSpring.entity.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuartoRepository extends JpaRepository<Quarto, Integer> {
    Quarto findByNumber (Integer number);
}
