package com.diplomado.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
@Getter
@Setter
@ToString
public class UserNameRolDTO {
    private Integer id;
    private Boolean active;
    private LocalDateTime createdAt;
    private String name;

    public UserNameRolDTO() {
    }
}
