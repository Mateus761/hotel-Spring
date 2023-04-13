package com.api.hotelSpring.controller;


import com.api.hotelSpring.dto.ErrorDto;
import com.api.hotelSpring.dto.UsuarioDto;
import com.api.hotelSpring.request.UsuarioRequest;
import com.api.hotelSpring.service.UsuarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.util.List;

@Api(tags = "Usuario Controller", consumes = "application/json")
@RestController
@RequiredArgsConstructor
@RequestMapping("usuario")
@Validated
public class UsuarioController {

    private final UsuarioService service;

    @ApiOperation(value = "Buscar todos usuários", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found usuários"),
            @ApiResponse(code = 500, message = "Internal server error", response =
                    ErrorDto.class)
    })
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<UsuarioDto>> all() {
        return ResponseEntity.status(HttpStatus.OK).body(service.all());
    }

    @ApiOperation(value = "Buscar usuário pelo nome", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully found usuário"),
            @ApiResponse(code = 404, message = "Usuário with this name does not exist", response =
                    ErrorDto.class)
    })
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDto> get(@PathVariable("name") String name){
        return ResponseEntity.status(HttpStatus.OK).body(service.get(name));
    }

    @ApiOperation(value = "Criar um novo usuário", produces = "application/json", consumes = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully created usuario"),
            @ApiResponse(code = 404, message = "Quarto not found", response = ErrorDto.class)
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UsuarioDto> save(@RequestBody @Validated UsuarioRequest request){
        UsuarioDto usuario = service.save(request);
       URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
               .path("/usuario/{id}")
               .buildAndExpand(usuario.getQuartoId())
               .toUri();

        return ResponseEntity.created(uri).body(usuario);
    }

    @ApiOperation(value = "Alterar usuário pelo nome", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated usuário"),
            @ApiResponse(code = 404, message = "Usuário with this name does not exist", response =
                    ErrorDto.class)
    })
    @PutMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UsuarioDto> update(@RequestBody UsuarioRequest request, @PathVariable("name") String name) {
        return  ResponseEntity.status(HttpStatus.OK).body(service.update(request, name));
    }

    @ApiOperation(value = "Deletar usuário pelo nome", produces = "application/json", consumes =
            "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted usuário"),
            @ApiResponse(code = 404, message = "Usuário with this name does not exist", response =
                    ErrorDto.class)
    })
    @DeleteMapping("/{name}")
    @ResponseStatus(HttpStatus.OK)
    public void delete (@PathVariable("name") String name) {
       service.delete(name);
   }
    }
