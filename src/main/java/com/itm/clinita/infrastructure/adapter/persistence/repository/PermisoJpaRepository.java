package com.itm.clinita.infrastructure.adapter.persistence.repository;

import com.itm.clinita.infrastructure.adapter.persistence.entity.PermisoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PermisoJpaRepository extends JpaRepository<PermisoEntity, Long> {
    Optional<PermisoEntity> findByNombre(String nombre);
}
