package com.diplomado.users.services;

import com.diplomado.users.dto.UserTableDTO;

import java.util.List;
import java.util.Optional;

public interface UserTableService {
    List<UserTableDTO> listUsers();
    List<UserTableDTO> listUsersDetailed();
    UserTableDTO save(UserTableDTO dto);
    Optional<UserTableDTO> edit(UserTableDTO dto);
    void delete(Long userTableId);
}
