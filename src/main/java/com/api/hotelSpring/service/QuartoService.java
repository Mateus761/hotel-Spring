package com.api.hotelSpring.service;


import com.api.hotelSpring.dto.QuartoDto;
import com.api.hotelSpring.entity.Hotel;
import com.api.hotelSpring.entity.Quarto;
import com.api.hotelSpring.exception.HotelNotFoundException;
import com.api.hotelSpring.exception.QuartoNotFoundException;
import com.api.hotelSpring.mapper.QuartoMapper;
import com.api.hotelSpring.repository.HotelRepository;
import com.api.hotelSpring.repository.QuartoRepository;
import com.api.hotelSpring.request.QuartoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuartoService {

    private final QuartoRepository repository;

    private final HotelRepository hotelRepository;

    public List<QuartoDto> all() {
        // cada elemento a gente fazia algo
        return repository.findAll().stream().map(QuartoMapper::toDto).collect(Collectors.toList());
        // transforma para stream
        // faz o map
        // transforma de volta pra lista
    }

    public QuartoDto get (Integer number){
        Quarto quarto = Optional.ofNullable(repository.findByNumber(number)).orElseThrow(() -> new
                QuartoNotFoundException("Quarto with number " + number + " does not exist"));
        return QuartoMapper.toDto(quarto);
    }

    @Transactional
    public QuartoDto save(QuartoRequest request){

        Hotel hotel =  hotelRepository.findById(request.getHotelId()).
                orElseThrow(() -> new HotelNotFoundException("Hotel with id " + request.getHotelId() + " does not exist"));

        Quarto newQuarto = repository.save(QuartoMapper.toEntity(request));

        newQuarto.addHotel(hotel);

        return QuartoMapper.toDto(newQuarto);

    }
    public void delete (Integer number){
        Quarto request = Optional.ofNullable(repository.findByNumber(number)).
                orElseThrow(() -> new QuartoNotFoundException("Quarto with number " + number +
                        " does not exist"));
        repository.deleteById(request.getId());
    }

    public QuartoDto update(QuartoRequest request, Integer number){
        Quarto quarto = Optional.ofNullable(repository.findByNumber(number)).
                orElseThrow(() -> new QuartoNotFoundException("Quarto with number " + number + " " +
                        "does not exist"));
        quarto.setAndar(request.getAndar());
        quarto.setNumber(request.getNumber());
        quarto.setTipo(request.getTipo());
        return QuartoMapper.toDto(repository.save(QuartoMapper.toEntity((request))));

    }

}
