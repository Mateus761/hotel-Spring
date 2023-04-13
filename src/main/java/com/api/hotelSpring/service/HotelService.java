package com.api.hotelSpring.service;


import com.api.hotelSpring.dto.HotelDto;
import com.api.hotelSpring.dto.HotelQuartosDto;
import com.api.hotelSpring.entity.Hotel;
import com.api.hotelSpring.exception.HotelNotFoundException;
import com.api.hotelSpring.mapper.HotelMapper;
import com.api.hotelSpring.repository.HotelRepository;
import com.api.hotelSpring.request.HotelRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;


    public List<HotelQuartosDto> getAllHotel(){
        return hotelRepository.findAll().stream().map(HotelMapper::toHotelQuartosDto).collect(Collectors.toList());
    }

    public HotelDto getHotel(String nomeDoHotel){
        Hotel hotel = Optional.ofNullable(hotelRepository.findByNomeDoHotel(nomeDoHotel)).orElseThrow(() -> new
                HotelNotFoundException("Hotel with name " + nomeDoHotel + " does not exist"));
        return HotelMapper.toDto(hotel);
    }

    public HotelDto postHotel(HotelRequest request){
        return HotelMapper.toDto(hotelRepository.save(HotelMapper.toEntity(request)));
    }

    public HotelDto updateHotel(HotelRequest request, String nomeDoHotel){
        Hotel hotel = Optional.ofNullable(hotelRepository.findByNomeDoHotel(nomeDoHotel)).orElseThrow(() -> new
                HotelNotFoundException("Hotel with name " + nomeDoHotel + " does not exist"));
        hotel.setNomeDoHotel(request.getNomeDoHotel());
        hotel.setDono(request.getDono());
        hotel.setLocation(request.getLocation());

        return HotelMapper.toDto(hotelRepository.save(HotelMapper.toEntity(request)));
    }

}
