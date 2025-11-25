package com.itm.clinita.domain.repository;

import com.itm.clinita.domain.model.Permiso;

import java.util.List;
import java.util.Optional;

public interface PermisoRepository {
    Optional<Permiso> findById(Long id);
    Optional<Permiso> findByNombre(String nombre);
    List<Permiso> findAll();
}
