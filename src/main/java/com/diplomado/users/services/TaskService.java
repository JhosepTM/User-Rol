package com.diplomado.users.services;

import com.diplomado.users.dto.StatusDTO;
import com.diplomado.users.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    List<TaskDTO> listTask();
    TaskDTO save(TaskDTO dto);
    void delete(Long taskId);
}
