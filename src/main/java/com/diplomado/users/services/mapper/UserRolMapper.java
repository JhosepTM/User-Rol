package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.dto.UserRolDTO;
import org.springframework.stereotype.Component;

@Component
public class UserRolMapper implements CustomMapper<UserRolDTO, UserRol> {

    private final UserTableMapper userTableMapper;
    private final RolMapper rolMapper;

    public UserRolMapper(UserTableMapper userTableMapper, RolMapper rolMapper) {
        this.userTableMapper = userTableMapper;
        this.rolMapper = rolMapper;
    }

    @Override
    public UserRolDTO toDto(UserRol userRol) {
        UserRolDTO userRolDTO = new UserRolDTO();
        userRolDTO.setId(userRol.getId());
        userRolDTO.setActive(userRol.getActive());
        userRolDTO.setCreatedAt(userRol.getCreatedAt());
        userRolDTO.setUser(userTableMapper.toDto(userRol.getUser()));
        userRolDTO.setRol(rolMapper.toDto(userRol.getRol()));
        return userRolDTO;
    }

    @Override
    public UserRol toEntity(UserRolDTO dto) {
        UserRol userRol = new UserRol();
        userRol.setId(dto.getId());
        userRol.setActive(dto.getActive());
        userRol.setCreatedAt(dto.getCreatedAt());
        System.out.println("1");
        userRol.setUser(userTableMapper.toEntity(dto.getUser()));
        System.out.println("2");
        userRol.setRol(rolMapper.toEntity(dto.getRol()));
        return userRol;
    }
}
