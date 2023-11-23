package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.UserTable;
import com.diplomado.users.dto.UserNameRolDTO;
import com.diplomado.users.dto.UserTableDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserTableMapper implements CustomMapper<UserTableDTO, UserTable>{

    private final UserDetailMapper userDetailMapper;
    private final UserNameRolMapper userNameRolMapper;

    public UserTableMapper(UserDetailMapper userDetailMapper, UserNameRolMapper userNameRolMapper) {
        this.userDetailMapper = userDetailMapper;
        this.userNameRolMapper = userNameRolMapper;
    }

    @Override
    public UserTableDTO toDto(UserTable userTable) {
        UserTableDTO userTableDTO = new UserTableDTO();
        userTableDTO.setId(userTable.getId());
        userTableDTO.setUserName(userTable.getUserName());
        userTableDTO.setPassword(userTable.getPassword());
        userTableDTO.setEmail(userTable.getEmail());
        userTableDTO.setCreatedAt(userTable.getCreatedAt());
        return userTableDTO;
    }

    public UserTableDTO toDtoDetailed(UserTable userTable) {
        UserTableDTO userTableDTO = new UserTableDTO();
        userTableDTO.setId(userTable.getId());
        userTableDTO.setUserName(userTable.getUserName());
        userTableDTO.setPassword(userTable.getPassword());
        userTableDTO.setEmail(userTable.getEmail());
        userTableDTO.setCreatedAt(userTable.getCreatedAt());
        if (userTable.getUserDetail() != null) {
            userTableDTO.setUserDetail(userDetailMapper.toDto(userTable.getUserDetail()));
        } else {
            userTableDTO.setUserDetail(null);
        }
        if (userTable.getListRoles() != null) {
            userTableDTO.setListRoles(userTable.getListRoles().stream().map(userNameRolMapper::toDto).collect(Collectors.toList()));
        } else {
            userTableDTO.setListRoles(null);
        }

        return userTableDTO;
    }

    @Override
    public UserTable toEntity(UserTableDTO dto) {
        UserTable userTable = new UserTable();
        userTable.setId(dto.getId());
        userTable.setUserName(dto.getUserName());
        userTable.setPassword(dto.getPassword());
        userTable.setEmail(dto.getEmail());
        userTable.setCreatedAt(dto.getCreatedAt());
        System.out.println("33333333333333");
        System.out.println(dto.getUserDetail());
        if (userTable.getUserDetail() != null) {
            userTable.setUserDetail(userDetailMapper.toEntity(dto.getUserDetail()));
        }
        return userTable;
    }
}
