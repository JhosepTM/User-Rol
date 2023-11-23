package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.repositories.RolRepository;
import com.diplomado.users.services.RolService;
import com.diplomado.users.services.mapper.RolMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImpl(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listRoles() {
        List<Rol> rol = rolRepository.findAll();
        return rol
                .stream()
                .map(rolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public Optional<RolDTO> getRolById(Integer rolId) {
        return rolRepository.findById(rolId)
                .map(rolMapper::toDto);
    }

    @Override
    public RolDTO save(RolDTO dto) {
        Rol rol = rolMapper.toEntity(dto);
        return rolMapper.toDto(rolRepository.save(rol));
    }

    @Override
    public void delete(Integer rolId) {
        rolRepository.deleteById(rolId);
    }
}
