package com.api.hotelSpring.mapper;

import com.api.hotelSpring.dto.UsuarioDto;
import com.api.hotelSpring.entity.Usuario;
import com.api.hotelSpring.request.UsuarioRequest;

public class UsuarioMapper {

    public static UsuarioDto toDto(Usuario entity){
        return UsuarioDto.builder()
                .name(entity.getName())
                .idade(entity.getIdade())
                .cpf(entity.getCpf())
                .tipo(entity.getTipo())
                .quartoId(entity.getQuarto().getId())
                .quarto(QuartoMapper.toDto(entity.getQuarto()))
                .build();
    }

    public static Usuario toEntity(UsuarioRequest request){
        return Usuario.builder()
                .name(request.getName())
                .idade(request.getIdade())
                .cpf(request.getCpf())
                .tipo(request.getTipo())
                .checkIn(request.getCheckIn())
                .checkOut(request.getCheckOut())
                .build();
    }
}
