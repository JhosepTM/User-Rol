package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.Status;
import com.diplomado.users.dto.StatusDTO;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper implements CustomMapper<StatusDTO, Status> {
    @Override
    public StatusDTO toDto(Status status) {
        StatusDTO dto = new StatusDTO();
        dto.setId(status.getId());
        dto.setNameStatus(status.getNameStatus());
        return dto;
    }

    @Override
    public Status toEntity(StatusDTO dto) {
        Status status = new Status();
        status.setId(dto.getId());
        status.setNameStatus(dto.getNameStatus());
        return status;
    }
}
