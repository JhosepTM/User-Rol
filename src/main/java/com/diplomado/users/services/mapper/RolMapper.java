package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.dto.RolDTO;
import org.springframework.stereotype.Component;

@Component
public class RolMapper implements CustomMapper<RolDTO, Rol>{
    @Override
    public RolDTO toDto(Rol rol) {
        RolDTO rolDTO = new RolDTO();
        rolDTO.setId(rol.getId());
        rolDTO.setName(rol.getName());
        return rolDTO;
    }

    @Override
    public Rol toEntity(RolDTO dto) {
        Rol rol = new Rol();
        rol.setId(dto.getId());
        rol.setName(dto.getName());
        return rol;
    }
}
