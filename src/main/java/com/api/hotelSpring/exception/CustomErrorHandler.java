package com.api.hotelSpring.exception;


import com.api.hotelSpring.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomErrorHandler {

    @ExceptionHandler({UsuarioNotFoundException.class, HotelNotFoundException.class, QuartoNotFoundException.class})
    public ResponseEntity<ErrorDto> handleErrorNotFound(EntityNotFoundException e){
        ErrorDto erroDto = ErrorDto.builder()
                .error(HttpStatus.NOT_FOUND.value())
                .message(e.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDto);
    }
}
