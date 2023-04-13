package com.api.hotelSpring.repository;

import com.api.hotelSpring.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HotelRepository extends JpaRepository <Hotel, Integer> {
    @Override
    Optional<Hotel> findById(Integer integer);

    Hotel findByNomeDoHotel (String nomeDoHotel);
}
