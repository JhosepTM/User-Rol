package com.diplomado.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
public class UserTableDTO {
    private Long id;
    private String userName;
    private String password;
    private String email;
    private LocalDateTime createdAt;

    private UserDetailDTO userDetail;
    private List<UserNameRolDTO> listRoles;

    public UserTableDTO() {
    }
}
