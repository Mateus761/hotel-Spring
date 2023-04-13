package com.api.hotelSpring.controller;


import com.api.hotelSpring.dto.ErrorDto;
import com.api.hotelSpring.dto.QuartoDto;
import com.api.hotelSpring.repository.QuartoRepository;
import com.api.hotelSpring.request.QuartoRequest;
import com.api.hotelSpring.service.QuartoService;
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
@RequiredArgsConstructor
@RequestMapping("quarto")
@Validated
public class QuartoController {

    private final QuartoRepository quartoRepository;

    private final QuartoService service;

    @ApiOperation(value = "Buscar todos quartos", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found quartos"),
            @ApiResponse(code = 500, message = "Internal server error", response =
                    ErrorDto.class)
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<QuartoDto> >all() {
        return ResponseEntity.status(HttpStatus.OK).body(service.all());
    }

    @ApiOperation(value = "Buscar quarto pelo número", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found quarto"),
            @ApiResponse(code = 404, message = "Quarto with this number does not exist", response =
                    ErrorDto.class)
    })
    @GetMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<QuartoDto> get(@PathVariable("number") Integer number){
        return ResponseEntity.status(HttpStatus.OK).body(service.get(number));
    }

    @ApiOperation(value = "Criar um novo quarto", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created quarto"),
            @ApiResponse(code = 404, message = "Hotel not found", response = ErrorDto.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<QuartoDto> save(@RequestBody QuartoRequest request){
        QuartoDto quarto = service.save(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/quarto/{id}")
                .buildAndExpand(quarto.getHotelId())
                .toUri();
            return ResponseEntity.created(uri).body(quarto);
        }

    @ApiOperation(value = "Alterar quarto pelo número", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated quarto"),
            @ApiResponse(code = 404, message = "Quarto with this number does not exist", response =
                    ErrorDto.class)
    })
    @PutMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<QuartoDto> update(@RequestBody QuartoRequest request, @PathVariable("number") Integer number) {
        return  ResponseEntity.status(HttpStatus.OK).body(service.update(request, number));
    }

    @ApiOperation(value = "Deletar quarto pelo número", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted quarto"),
            @ApiResponse(code = 404, message = "Quarto with this number does not exist", response =
                    ErrorDto.class)
    })
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{number}")
    public void delete (@PathVariable("number") Integer number) {
        service.delete(number);
    }
}