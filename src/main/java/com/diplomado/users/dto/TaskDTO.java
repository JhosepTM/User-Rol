package com.diplomado.users.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TaskDTO {
    private Long id;
    private String description;
    private LocalDateTime dueDate;
    private StatusDTO status;
    private UserTableDTO user;

    public TaskDTO() {
    }
}
