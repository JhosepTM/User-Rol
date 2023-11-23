package com.diplomado.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class UserRolDTO {
    private Integer id;
    private Boolean active;
    private LocalDateTime createdAt;
    private UserTableDTO user;
    private RolDTO rol;

    public UserRolDTO() {
    }
}
