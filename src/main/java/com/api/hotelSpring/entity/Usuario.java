package com.api.hotelSpring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private Integer idade;

    private Long cpf;

    private String tipo;

    private String checkIn;

    private String checkOut;

    @OneToOne
    @JoinColumn(name = "quarto_id", referencedColumnName = "id")
    private  Quarto quarto;

      public void addQuarto(Quarto quarto){
        setQuarto(quarto);
        setTipo(quarto.getTipo());
        quarto.setUsuario(this);
    }
}
