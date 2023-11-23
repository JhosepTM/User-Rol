package com.diplomado.users.services.mapper;

import com.diplomado.users.domain.entities.Task;
import com.diplomado.users.dto.TaskDTO;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper implements CustomMapper<TaskDTO, Task> {

    private final UserTableMapper userTableMapper;
    private final StatusMapper statusMapper;

    public TaskMapper(UserTableMapper userTableMapper, StatusMapper statusMapper) {
        this.userTableMapper = userTableMapper;
        this.statusMapper = statusMapper;
    }

    @Override
    public TaskDTO toDto(Task task) {
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setDescription(task.getDescription());
        dto.setDueDate(task.getDueDate());
        dto.setStatus(statusMapper.toDto(task.getStatus()));
        dto.setUser(userTableMapper.toDto(task.getUser()));
        return dto;
    }

    @Override
    public Task toEntity(TaskDTO dto) {
        Task task = new Task();
        task.setId(dto.getId());
        task.setDescription(dto.getDescription());
        task.setDueDate(dto.getDueDate());
        task.setStatus(statusMapper.toEntity(dto.getStatus()));
        task.setUser(userTableMapper.toEntity(dto.getUser()));
        return task;
    }
}
