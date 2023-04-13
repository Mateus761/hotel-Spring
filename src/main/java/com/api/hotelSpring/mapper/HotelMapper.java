package com.api.hotelSpring.mapper;


import com.api.hotelSpring.dto.HotelDto;
import com.api.hotelSpring.dto.HotelQuartosDto;
import com.api.hotelSpring.entity.Hotel;
import com.api.hotelSpring.request.HotelRequest;

import java.util.stream.Collectors;

public class HotelMapper {

    public static HotelDto toDto(Hotel entity){
        return HotelDto .builder()
                .nomeDoHotel(entity.getNomeDoHotel())
                .dono(entity.getDono())
                .location(entity.getLocation())
                .build();
    }

    public static HotelQuartosDto toHotelQuartosDto(Hotel entity){
        return HotelQuartosDto.builder()
                .nomeDoHotel(entity.getNomeDoHotel())
                .dono(entity.getDono())
                .location(entity.getLocation())
                .quartos(entity.getQuartos().stream().map(QuartoMapper::toDto).collect(Collectors.toList()))
                .build();
    }

    public static Hotel toEntity(HotelRequest request){
        return Hotel.builder()
                .nomeDoHotel(request.getNomeDoHotel())
                .dono(request.getDono())
                .location(request.getLocation())
                .build();
    }
}
