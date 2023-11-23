package com.diplomado.users.web.rest;

import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.dto.TaskDTO;
import com.diplomado.users.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody final TaskDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new task cannot already have an id");
        }

        TaskDTO taskDTO = taskService.save(dto);

        return ResponseEntity.created(new URI("/v1/tasks/"+taskDTO.getId())).body(taskDTO);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTO>> listAllTasks() {
        return ResponseEntity.ok().body(taskService.listTask());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
