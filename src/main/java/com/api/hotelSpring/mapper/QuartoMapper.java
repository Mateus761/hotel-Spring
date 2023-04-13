package com.api.hotelSpring.mapper;

import com.api.hotelSpring.dto.QuartoDto;
import com.api.hotelSpring.entity.Quarto;
import com.api.hotelSpring.request.QuartoRequest;

public class QuartoMapper {

    public static QuartoDto toDto(Quarto entity){
        return QuartoDto.builder()
                .andar(entity.getAndar())
                .number(entity.getNumber())
                .tipo(entity.getTipo())
                //.usuarioId(entity.getUsuario().getId())
                //.usuario(UsuarioMapper.toDto(entity.getUsuario()))
                .hotelId(entity.getHotel().getId())
                .hotel(HotelMapper.toDto(entity.getHotel()))
                .build();
    }

    public static Quarto toEntity(QuartoRequest request){
        return Quarto.builder()
                .andar(request.getAndar())
                .number(request.getNumber())
                .tipo(request.getTipo())
                .qtdCamas(request.getQtdCamas())
                .qtdPessoas(request.getQtdPessoas())
                .build();
    }
}