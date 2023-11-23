package com.diplomado.users.services.implement;

import com.diplomado.users.domain.entities.Task;
import com.diplomado.users.dto.TaskDTO;
import com.diplomado.users.repositories.TaskRepository;
import com.diplomado.users.services.TaskService;
import com.diplomado.users.services.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository, TaskMapper taskMapper) {
        this.taskRepository = taskRepository;
        this.taskMapper = taskMapper;
    }

    @Override
    public List<TaskDTO> listTask() {
        List<Task> tasks = taskRepository.findAll();
        return tasks
                .stream()
                .map(taskMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public TaskDTO save(TaskDTO dto) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(dto)));
    }

    @Override
    public void delete(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
