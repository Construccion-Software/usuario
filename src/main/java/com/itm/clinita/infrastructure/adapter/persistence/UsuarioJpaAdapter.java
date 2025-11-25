package com.itm.clinita.infrastructure.adapter.persistence;

import com.itm.clinita.domain.model.Usuario;
import com.itm.clinita.domain.repository.UsuarioRepository;
import com.itm.clinita.infrastructure.adapter.persistence.mapper.UsuarioMapper;
import com.itm.clinita.infrastructure.adapter.persistence.repository.UsuarioJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsuarioJpaAdapter implements UsuarioRepository {

    private final UsuarioJpaRepository jpaRepository;
    private final UsuarioMapper mapper;

    @Override
    public Usuario save(Usuario usuario) {
        var entity = mapper.toEntity(usuario);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByCedula(String cedula) {
        return jpaRepository.findByCedula(cedula)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Usuario> findByCorreo(String correo) {
        return jpaRepository.findByCorreo(correo)
                .map(mapper::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Usuario> findAllActivos() {
        return jpaRepository.findByActivoTrue().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void cambiarEstado(Long id, Boolean activo) {
        jpaRepository.cambiarEstado(id, activo);
    }

    @Override
    public boolean existsByCedula(String cedula) {
        return jpaRepository.existsByCedula(cedula);
    }

    @Override
    public boolean existsByCorreo(String correo) {
        return jpaRepository.existsByCorreo(correo);
    }
}
