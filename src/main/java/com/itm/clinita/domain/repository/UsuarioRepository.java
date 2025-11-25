package com.itm.clinita.domain.repository;

import com.itm.clinita.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario save(Usuario usuario);
    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByCedula(String cedula);
    Optional<Usuario> findByCorreo(String correo);
    List<Usuario> findAll();
    List<Usuario> findAllActivos();
    void cambiarEstado(Long id, Boolean activo);
    boolean existsByCedula(String cedula);
    boolean existsByCorreo(String correo);
}
