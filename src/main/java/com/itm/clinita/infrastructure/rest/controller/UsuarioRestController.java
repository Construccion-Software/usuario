package com.itm.clinita.infrastructure.rest.controller;

import com.itm.clinita.application.command.AsignarRolCommand;
import com.itm.clinita.domain.usecase.*;
import com.itm.clinita.infrastructure.rest.dto.request.AsignarRolRequest;
import com.itm.clinita.infrastructure.rest.dto.request.CrearUsuarioRequest;
import com.itm.clinita.infrastructure.rest.dto.response.ApiResponse;
import com.itm.clinita.infrastructure.rest.dto.response.UsuarioResponse;
import com.itm.clinita.infrastructure.rest.mapper.UsuarioRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRestController {

    private final CrearUsuarioUseCase crearUsuario;
    private final CambiarEstadoUsuarioUseCase cambiarEstadoUsuario;
    private final ObtenerUsuarioUseCase obtenerUsuario;
    private final ListarUsuariosUseCase listarUsuarios;
    private final AsignarRolUseCase asignarRol;
    private final UsuarioRestMapper mapper;

    @PostMapping
    public ResponseEntity<ApiResponse<UsuarioResponse>> crearUsuario(
            @Valid @RequestBody CrearUsuarioRequest request) {

        var command = mapper.toCommand(request);
        var usuario = crearUsuario.execute(command);
        var response = mapper.toResponse(usuario);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ApiResponse.success(response, "Usuario creado exitosamente"));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<UsuarioResponse>>> listarUsuarios() {
        var usuarios = listarUsuarios.execute();
        var responses = usuarios.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                ApiResponse.success(responses, "Usuarios obtenidos exitosamente")
        );
    }

    @GetMapping("/activos")
    public ResponseEntity<ApiResponse<List<UsuarioResponse>>> listarUsuariosActivos() {
        var usuarios = listarUsuarios.listarActivos();
        var responses = usuarios.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                ApiResponse.success(responses, "Usuarios activos obtenidos exitosamente")
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UsuarioResponse>> obtenerUsuario(
            @PathVariable Long id) {

        var usuario = obtenerUsuario.execute(id);
        var response = mapper.toResponse(usuario);

        return ResponseEntity.ok(
                ApiResponse.success(response, "Usuario obtenido exitosamente")
        );
    }

    @GetMapping("/cedula/{cedula}")
    public ResponseEntity<ApiResponse<UsuarioResponse>> obtenerPorCedula(
            @PathVariable String cedula) {

        var usuario = obtenerUsuario.obtenerPorCedula(cedula);
        var response = mapper.toResponse(usuario);

        return ResponseEntity.ok(
                ApiResponse.success(response, "Usuario obtenido exitosamente")
        );
    }

    @PatchMapping("/{id}/desactivar")
    public ResponseEntity<ApiResponse<Void>> desactivarUsuario(@PathVariable Long id) {
        cambiarEstadoUsuario.desactivar(id);

        return ResponseEntity.ok(
                ApiResponse.success(null, "Usuario desactivado exitosamente")
        );
    }

    @PatchMapping("/{id}/activar")
    public ResponseEntity<ApiResponse<Void>> activarUsuario(@PathVariable Long id) {
        cambiarEstadoUsuario.activar(id);

        return ResponseEntity.ok(
                ApiResponse.success(null, "Usuario activado exitosamente")
        );
    }

    @PutMapping("/asignar-rol")
    public ResponseEntity<ApiResponse<UsuarioResponse>> asignarRol(
            @Valid @RequestBody AsignarRolRequest request) {

        var command = AsignarRolCommand.builder()
                .idUsuario(request.getIdUsuario())
                .idRol(request.getIdRol())
                .build();

        var usuario = asignarRol.execute(command);
        var response = mapper.toResponse(usuario);

        return ResponseEntity.ok(
                ApiResponse.success(response, "Rol asignado exitosamente")
        );
    }
}