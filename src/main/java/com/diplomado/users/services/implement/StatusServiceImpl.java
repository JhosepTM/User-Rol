package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.domain.entities.Status;
import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.dto.StatusDTO;
import com.diplomado.users.repositories.StatusRepository;
import com.diplomado.users.services.StatusService;
import com.diplomado.users.services.mapper.StatusMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StatusServiceImpl implements StatusService {
    private final StatusRepository statusRepository;
    private final StatusMapper statusMapper;

    public StatusServiceImpl(StatusRepository statusRepository, StatusMapper statusMapper) {
        this.statusRepository = statusRepository;
        this.statusMapper = statusMapper;
    }

    @Override
    public List<StatusDTO> listStatus() {
        List<Status> status = statusRepository.findAll();
        return status
                .stream()
                .map(statusMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public StatusDTO save(StatusDTO dto) {
        return statusMapper.toDto(statusRepository.save(statusMapper.toEntity(dto)));
    }

    @Override
    public void delete(Integer statusId) {
        statusRepository.deleteById(statusId);
    }
}
