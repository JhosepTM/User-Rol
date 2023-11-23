package com.diplomado.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class StatusDTO {
    private Integer id;
    private String nameStatus;

    public StatusDTO() {
    }
}
