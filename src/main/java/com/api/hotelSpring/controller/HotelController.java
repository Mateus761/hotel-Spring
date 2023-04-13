package com.api.hotelSpring.controller;

import com.api.hotelSpring.dto.ErrorDto;
import com.api.hotelSpring.dto.HotelDto;
import com.api.hotelSpring.dto.HotelQuartosDto;
import com.api.hotelSpring.request.HotelRequest;
import com.api.hotelSpring.service.HotelService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Validated
@RequestMapping("hotel")
@RequiredArgsConstructor
public class HotelController {

    private final HotelService hotelService;

    @ApiOperation(value = "Buscar todos hotéis", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found hotéis"),
            @ApiResponse(code = 500, message = "Internal server error", response =
                    ErrorDto.class)
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<HotelQuartosDto>>getAllHotel(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
    }

    @ApiOperation(value = "Buscar hotel pelo nome", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found hotel"),
            @ApiResponse(code = 404, message = "Hotel with this name does not exist", response =
                    ErrorDto.class)
    })
    @GetMapping("/{nomeDoHotel}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<HotelDto> getHotel(@PathVariable("nomeDoHotel") String nomeDoHotel){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(nomeDoHotel));
    }

    @ApiOperation(value = "Criar um novo hotel", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created hotel"),
            @ApiResponse(code = 404, message = "Hotel not found", response = ErrorDto.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<HotelDto> postHotel(@RequestBody @Validated HotelRequest request){
        HotelDto hotel = hotelService.postHotel(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/hotel/{id}")
                .buildAndExpand(hotel.hashCode())
                .toUri();
        return ResponseEntity.created(uri).body(hotel);
    }

    @ApiOperation(value = "Alterar hotel pelo nome", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated hotel"),
            @ApiResponse(code = 404, message = "Hotel with this name does not exist", response =
                    ErrorDto.class)
    })
    @PutMapping("/{nomeDoHotel}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<HotelDto> updateHotel(@RequestBody HotelRequest request, @PathVariable("nomeDoHotel") String nomeDoHotel){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.updateHotel(request, nomeDoHotel));
    }
}