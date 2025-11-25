package com.itm.clinita.infrastructure.adapter.persistence;

import com.itm.clinita.domain.model.Rol;
import com.itm.clinita.domain.repository.RolRepository;
import com.itm.clinita.infrastructure.adapter.persistence.mapper.RolMapper;
import com.itm.clinita.infrastructure.adapter.persistence.repository.RolJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RolJpaAdapter implements RolRepository {

    private final RolJpaRepository jpaRepository;
    private final RolMapper mapper;

    @Override
    public Optional<Rol> findById(Long id) {
        return jpaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Rol> findByNombre(String nombre) {
        return jpaRepository.findByNombre(nombre)
                .map(mapper::toDomain);
    }

    @Override
    public List<Rol> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }
}
