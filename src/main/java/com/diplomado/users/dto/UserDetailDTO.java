package com.diplomado.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class UserDetailDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date birthDay;

    public UserDetailDTO() {
    }
}
