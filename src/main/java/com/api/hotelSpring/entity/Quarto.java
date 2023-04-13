package com.api.hotelSpring.entity;


import com.api.hotelSpring.dto.UsuarioDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "QUARTO")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quarto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer andar;

    private Integer number;

    private String tipo;

    private Integer qtdCamas;

    private Integer qtdPessoas;

    @OneToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id")
    private Hotel hotel;

   /*public void addUsuario(Usuario usuario){
        setUsuario(usuario);
        setTipo(usuario.getTipo());
        usuario.setQuarto(this);
    }*/

    public void addHotel(Hotel hotel){
        setHotel(hotel);
        hotel.getQuartos().add(this);
   }

}
