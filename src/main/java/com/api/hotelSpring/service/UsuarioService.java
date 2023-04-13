package com.api.hotelSpring.service;


import com.api.hotelSpring.dto.UsuarioDto;
import com.api.hotelSpring.entity.Quarto;
import com.api.hotelSpring.entity.Usuario;
import com.api.hotelSpring.exception.QuartoNotFoundException;
import com.api.hotelSpring.exception.UsuarioNotFoundException;
import com.api.hotelSpring.mapper.UsuarioMapper;
import com.api.hotelSpring.repository.QuartoRepository;
import com.api.hotelSpring.repository.UsuarioRepository;
import com.api.hotelSpring.request.UsuarioRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    private final QuartoRepository quartoRepository;

    public List<UsuarioDto> all() {
        // cada elemento a gente fazia algo
        return repository.findAll().stream().map(UsuarioMapper::toDto).collect(Collectors.toList());
        // transforma para stream
        // faz o map
        // transforma de volta pra lista
    }

    public UsuarioDto get (String name){
        Usuario usuario = Optional.ofNullable(repository.findByName(name)).
                orElseThrow(() -> new UsuarioNotFoundException("Usuario com o nome " + name + " " +
                        "does not exist"));
        return UsuarioMapper.toDto(usuario);
    }

    @Transactional
    public UsuarioDto save(UsuarioRequest request){
          Quarto quarto = quartoRepository.findById(request.getQuartoId()).
                orElseThrow(() -> new QuartoNotFoundException("Quarto with id " + request.getQuartoId() + " does " +
                        "not " + "exist"));

          Usuario newUsuario = repository.save(UsuarioMapper.toEntity(request));

         newUsuario.addQuarto(quarto);

        return UsuarioMapper.toDto(newUsuario);
    }
    public void delete (String name){
        Usuario request = Optional.ofNullable(repository.findByName(name)).
                orElseThrow(() -> new UsuarioNotFoundException("Usuario com o nome " + name + " " +
                "does not exist"));
        repository.deleteById(request.getId());
    }

    public UsuarioDto update(UsuarioRequest request, String name){
        Usuario usuario = Optional.ofNullable(repository.findByName(name)).
                orElseThrow(() -> new UsuarioNotFoundException("Usuario com o nome " + name + " " +
                "does not exist"));
        usuario.setName(request.getName());
        usuario.setIdade(request.getIdade());
        usuario.setCpf(request.getCpf());
        usuario.setTipo(request.getTipo());

        return UsuarioMapper.toDto(repository.save(UsuarioMapper.toEntity((request))));

    }

}
