package com.itm.clinita.infrastructure.adapter.persistence;

import com.itm.clinita.domain.model.Permiso;
import com.itm.clinita.domain.repository.PermisoRepository;
import com.itm.clinita.infrastructure.adapter.persistence.mapper.PermisoMapper;
import com.itm.clinita.infrastructure.adapter.persistence.repository.PermisoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PermisoJpaAdapter implements PermisoRepository {

    private final PermisoJpaRepository jpaRepository;
    private final PermisoMapper mapper;

    @Override
    public Optional<Permiso> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Permiso> findByNombre(String nombre) {
        return jpaRepository.findByNombre(nombre)
                .map(mapper::toDomain);
    }

    @Override
    public List<Permiso> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
