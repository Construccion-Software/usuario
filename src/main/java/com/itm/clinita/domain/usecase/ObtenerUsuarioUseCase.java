package com.itm.clinita.domain.usecase;

import com.itm.clinita.domain.exception.UsuarioNoEncontradoException;
import com.itm.clinita.domain.model.Usuario;
import com.itm.clinita.domain.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ObtenerUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    @Transactional(readOnly = true)
    public Usuario execute(Long idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new UsuarioNoEncontradoException(
                        "No se encontró el usuario con id: " + idUsuario
                ));
    }

    @Transactional(readOnly = true)
    public Usuario obtenerPorCedula(String cedula) {
        return usuarioRepository.findByCedula(cedula)
                .orElseThrow(() -> new UsuarioNoEncontradoException(
                        "No se encontró el usuario con cédula: " + cedula
                ));
    }
}