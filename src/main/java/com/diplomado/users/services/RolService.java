package com.diplomado.users.services;

import com.diplomado.users.dto.RolDTO;

import java.util.List;
import java.util.Optional;

public interface RolService {
    List<RolDTO> listRoles();
    Optional<RolDTO> getRolById(Integer rolId);
    RolDTO save(RolDTO dto);
    void delete(Integer rolId);
}
