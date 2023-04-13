package com.api.hotelSpring.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "HOTEL")
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nomeDoHotel;

    private String dono;

    private String location;


    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private final List<Quarto> quartos = new ArrayList<>();
}
