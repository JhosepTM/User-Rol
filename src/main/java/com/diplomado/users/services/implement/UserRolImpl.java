package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.Rol;
import com.diplomado.users.domain.entities.UserRol;
import com.diplomado.users.domain.entities.UserTable;
import com.diplomado.users.dto.UserRolDTO;
import com.diplomado.users.dto.UserTableDTO;
import com.diplomado.users.repositories.RolRepository;
import com.diplomado.users.repositories.UserRolRepository;
import com.diplomado.users.repositories.UserTableRepository;
import com.diplomado.users.services.UserRolService;
import com.diplomado.users.services.mapper.UserRolMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRolImpl implements UserRolService {
    private final UserRolRepository userRolRepository;
    private final UserTableRepository userTableRepository;
    private final RolRepository rolRepository;
    private final UserRolMapper userRolMapper;

    public UserRolImpl(UserRolRepository userRolRepository, UserTableRepository userTableRepository, RolRepository rolRepository, UserRolMapper userRolMapper) {
        this.userRolRepository = userRolRepository;
        this.userTableRepository = userTableRepository;
        this.rolRepository = rolRepository;
        this.userRolMapper = userRolMapper;
    }

    @Override
    public List<UserTableDTO> getUsersByRolId(Integer userId) {
        return userRolRepository.findAllByRolIdOrderById(userId)
                .stream()
                .map(userRol -> userRolMapper.toDto(userRol).getUser()).collect(Collectors.toList());
    }

    @Override
    public UserRolDTO create(Long userId, Integer rolId) {
        UserRol existRol = userRolRepository.findFirstByUserIdAndRolId(userId,rolId);
        if (existRol != null) {
            throw new IllegalArgumentException("Invalid rol, already assigned");
        }
        Optional<UserTable> user = userTableRepository.findById(userId);
        Optional<Rol> rol = rolRepository.findById(rolId);
        if ( rol.isPresent() && user.isPresent()) {
            UserRol userRol = new UserRol(true,LocalDateTime.now(),user.get(),rol.get());
            userRol = userRolRepository.save(userRol);
            return userRolMapper.toDto(userRol);
        } else {
            throw new IllegalArgumentException("Invalid rol id or user id");
        }
    }

    @Override
    public void changeStatus(Long userId, Integer rolId, Boolean newSatatus) {
        UserRol userRol = userRolRepository.findFirstByUserIdAndRolId(userId,rolId);
        userRol.setActive(newSatatus);
        userRolRepository.save(userRol);
    }

    @Override
    public void delete(Long userId, Integer rolId) {

        userRolRepository.deleteById(userRolRepository.findFirstByUserIdAndRolId(userId,rolId).getId());
    }
}
