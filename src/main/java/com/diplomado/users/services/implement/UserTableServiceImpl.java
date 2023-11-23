package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.UserDetail;
import com.diplomado.users.domain.entities.UserTable;
import com.diplomado.users.dto.UserTableDTO;
import com.diplomado.users.repositories.UserDetailRepository;
import com.diplomado.users.repositories.UserTableRepository;
import com.diplomado.users.services.UserTableService;
import com.diplomado.users.services.mapper.UserDetailMapper;
import com.diplomado.users.services.mapper.UserTableMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserTableServiceImpl implements UserTableService {

    private final UserTableRepository userTableRepository;
    private final UserTableMapper userTableMapper;
    private final UserDetailRepository userDetailRepository;
    private final UserDetailMapper userDetailMapper;

    public UserTableServiceImpl(UserTableRepository userTableRepository, UserTableMapper userTableMapper, UserDetailRepository userDetailRepository, UserDetailMapper userDetailMapper) {
        this.userTableRepository = userTableRepository;
        this.userTableMapper = userTableMapper;
        this.userDetailRepository = userDetailRepository;
        this.userDetailMapper = userDetailMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserTableDTO> listUsers() {
        return userTableRepository.findAll()
                .stream()
                .map(userTableMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserTableDTO> listUsersDetailed() {
        return userTableRepository.findAll()
                .stream()
                .map(userTableMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    public UserTableDTO save(UserTableDTO dto) {
        UserTable userTable = userTableRepository.save(userTableMapper.toEntity(dto));
        if (dto.getUserDetail() != null ) {
            UserDetail userDetail = userDetailMapper.toEntity(dto.getUserDetail());
            userDetail.setUser(userTable);
            userTable.setUserDetail(userDetailRepository.save(userDetail));
        }
        return userTableMapper.toDtoDetailed(userTable);
    }

    @Override
    public Optional<UserTableDTO> edit(UserTableDTO dto) {
        return userTableRepository.findById(dto.getId())
                .map(userTable -> {
                    if (dto.getUserName() != null) {
                        userTable.setUserName(dto.getUserName());
                    }
                    if (dto.getPassword() != null) {
                        userTable.setPassword(dto.getPassword());
                    }
                    if (dto.getEmail() != null) {
                        userTable.setEmail(dto.getEmail());
                    }
                    return userTableMapper.toDto(userTableRepository.save(userTable));
                });
    }

    @Override
    public void delete(Long userTableId) {
        userTableRepository.deleteById(userTableId);
    }
}
