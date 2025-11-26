package com.itm.clinita.infrastructure.rest.controller;

import com.itm.clinita.domain.usecase.ListarRolesUseCase;
import com.itm.clinita.infrastructure.rest.dto.response.ApiResponse;
import com.itm.clinita.infrastructure.rest.dto.response.RolResponse;
import com.itm.clinita.infrastructure.rest.mapper.RolRestMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RolRestController {

    private final ListarRolesUseCase listarRoles;
    private final RolRestMapper mapper;

    @GetMapping
    public ResponseEntity<ApiResponse<List<RolResponse>>> listarRoles() {
        var roles = listarRoles.execute();
        var responses = roles.stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                ApiResponse.success(responses, "Roles obtenidos exitosamente")
        );
    }
}