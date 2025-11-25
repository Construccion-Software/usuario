package com.itm.clinita.domain.usecase;

import com.itm.clinita.domain.model.Rol;
import com.itm.clinita.domain.repository.RolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListarRolesUseCase {

    private final RolRepository rolRepository;

    @Transactional(readOnly = true)
    public List<Rol> execute() {
        return rolRepository.findAll();
    }
}
