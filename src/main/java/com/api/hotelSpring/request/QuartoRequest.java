package com.api.hotelSpring.request;


import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuartoRequest {

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Andar do quarto", required = true)
    private Integer andar;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Número do quarto", required = true)
    private Integer number;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Tipo do quarto", required = true)
    private String tipo;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Quantidade de camas que o quarto possui", required = true)
    private Integer qtdCamas;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Quantidade de pessoas que o quarto suporta", required = true)
    private Integer qtdPessoas;

   // @NotNull
   // private Integer usuarioId;

    @NotNull
    @NotBlank
    @ApiModelProperty(notes = "Id do hotel do quarto", required = true)
    private Integer hotelId;
}