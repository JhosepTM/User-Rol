package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.dto.UserNameRolDTO;
import com.diplomado.users.dto.UserRolDTO;
import org.springframework.stereotype.Component;

@Component
public class UserNameRolMapper implements CustomMapper<UserNameRolDTO, UserRol> {

    @Override
    public UserNameRolDTO toDto(UserRol userRol) {
        UserNameRolDTO dto = new UserNameRolDTO();
        dto.setId(userRol.getId());
        dto.setActive(userRol.getActive());
        dto.setCreatedAt(userRol.getCreatedAt());
        dto.setName(userRol.getRol().getName());
        return dto;
    }

    @Override
    public UserRol toEntity(UserNameRolDTO dto) {
        UserRol userRol = new UserRol();
        userRol.setId(dto.getId());
        userRol.setActive(dto.getActive());
        userRol.setCreatedAt(dto.getCreatedAt());
        return userRol;
    }
}
