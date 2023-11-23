package com.diplomado.users.services;

import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.dto.StatusDTO;

import java.util.List;

public interface StatusService {
    List<StatusDTO> listStatus();
    StatusDTO save(StatusDTO dto);
    void delete(Integer statusId);
}
