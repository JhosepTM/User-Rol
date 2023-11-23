package com.diplomado.users.services;

import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.dto.UserRolDTO;
import com.diplomado.users.dto.UserTableDTO;

import java.util.List;
import java.util.Optional;

public interface UserRolService {
    List<UserTableDTO> getUsersByRolId(Integer userId);
    UserRolDTO create(Long userId, Integer rolId);

    void changeStatus(Long userId, Integer rolId, Boolean newStatus);

    void delete(Long userId, Integer rolId);
}
