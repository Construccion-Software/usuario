package com.itm.clinita.domain.repository;

import com.itm.clinita.domain.model.Rol;

import java.util.List;
import java.util.Optional;

public interface RolRepository {
    Optional<Rol> findById(Long id);
    Optional<Rol> findByNombre(String nombre);
    List<Rol> findAll();
}