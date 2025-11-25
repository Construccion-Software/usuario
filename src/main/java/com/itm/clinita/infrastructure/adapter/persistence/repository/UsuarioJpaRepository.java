package com.itm.clinita.infrastructure.adapter.persistence.repository;

import com.itm.clinita.infrastructure.adapter.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findByCedula(String cedula);
    Optional<UsuarioEntity> findByCorreo(String correo);
    boolean existsByCedula(String cedula);
    boolean existsByCorreo(String correo);
    List<UsuarioEntity> findByActivoTrue();

    @Modifying
    @Query("UPDATE UsuarioEntity u SET u.activo = :activo WHERE u.idUsuario = :id")
    void cambiarEstado(@Param("id") Long id, @Param("activo") Boolean activo);
}

