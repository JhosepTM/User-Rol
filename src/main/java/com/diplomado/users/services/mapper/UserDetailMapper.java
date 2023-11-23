package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.UserDetail;
import com.diplomado.users.dto.UserDetailDTO;
import com.diplomado.users.dto.UserTableDTO;
import org.springframework.stereotype.Component;

@Component
public class UserDetailMapper implements CustomMapper<UserDetailDTO, UserDetail> {
    @Override
    public UserDetailDTO toDto(UserDetail userDetail) {
        UserDetailDTO userDetailDTO = new UserDetailDTO();
        userDetailDTO.setId(userDetail.getId());
        userDetailDTO.setFirstName(userDetail.getFirstName());
        userDetailDTO.setLastName(userDetail.getLastName());
        userDetailDTO.setAge(userDetail.getAge());
        userDetailDTO.setBirthDay(userDetail.getBirthDay());
        return userDetailDTO;
    }

    @Override
    public UserDetail toEntity(UserDetailDTO dto) {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(dto.getId());
        userDetail.setFirstName(dto.getFirstName());
        userDetail.setLastName(dto.getLastName());
        userDetail.setAge(dto.getAge());
        userDetail.setBirthDay(dto.getBirthDay());
        return userDetail;
    }
}
