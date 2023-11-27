package com.diplomado.users.web.rest;

import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.dto.UserTableDTO;
import com.diplomado.users.services.UserRolService;
import com.diplomado.users.services.UserTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/v1/users")
public class UserTableController {
    private final UserTableService userTableService;
    private final UserRolService userRolService;

    public UserTableController(UserTableService userTableService, UserRolService userRolService) {
        this.userTableService = userTableService;
        this.userRolService = userRolService;
    }

    @GetMapping
    public ResponseEntity<List<UserTableDTO>> listUsers(@RequestParam(required = false, defaultValue = "false") boolean detailed) {
        if (detailed) {
            return ResponseEntity.ok().body(userTableService.listUsersDetailed());
        } else {
            return ResponseEntity.ok().body(userTableService.listUsers());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserTableDTO> getRolById(@PathVariable final Long id) throws URISyntaxException {
        return ResponseEntity.ok()
                .body(userTableService.getUserById(id)
                        .orElseThrow(()->new IllegalArgumentException("Resource not found exception for: "+ id)));
    }

    @PostMapping
    public ResponseEntity<UserTableDTO> create(@RequestBody final UserTableDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new user cannot already have an id");
        }

        dto.setCreatedAt(LocalDateTime.now());
        UserTableDTO userTableDTO = userTableService.save(dto);

        return ResponseEntity.created(new URI("/v1/users/"+userTableDTO.getId())).body(userTableDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UserTableDTO> edit(@RequestBody final UserTableDTO dto,
                                          @PathVariable final Long id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid user id, null value");
        }
        if (!Objects.equals(dto.getId(),id)) {
            throw new IllegalArgumentException("Invalid id");
        }

        return ResponseEntity.ok().body(userTableService.edit(dto)
                .orElseThrow(()->new IllegalArgumentException("Resource not found exception for: "+ id)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Long id) {
        userTableService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/roles")
    public ResponseEntity<String> assignRoles(@PathVariable final Long id
            , @RequestBody final Map<String,List<Integer>> roles) throws URISyntaxException {
        if (roles != null && roles.containsKey("list")) {
            List<Integer> listRoles = roles.get("list");
            listRoles.forEach(rolId -> {
                userRolService.create(id, rolId);
            });
            return ResponseEntity.ok("Assinged roles: "+listRoles.size());
        } else {
            throw new IllegalArgumentException("Invalid list roles, null value");
        }
    }

}
