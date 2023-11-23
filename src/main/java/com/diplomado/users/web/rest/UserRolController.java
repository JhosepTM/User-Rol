package com.diplomado.users.web.rest;

import com.diplomado.users.dto.UserRolDTO;
import com.diplomado.users.dto.UserTableDTO;
import com.diplomado.users.services.UserRolService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
//@RequestMapping("/v1/users/{userId}/roles")
@RequestMapping("/v1/roles/{rolId}/users")
public class UserRolController {
    private final UserRolService userRolService;

    public UserRolController(UserRolService userRolService) {
        this.userRolService = userRolService;
    }

    @GetMapping
    public ResponseEntity<List<UserTableDTO>> getUsersByRolId(@PathVariable final Integer rolId) {
        return ResponseEntity.ok().body(userRolService.getUsersByRolId(rolId));
    }

    @PatchMapping("/{userId}/status")
    public ResponseEntity<Void> changeStatus(@PathVariable final Long userId,
                                             @PathVariable final Integer rolId,
                                             @RequestParam(defaultValue = "false") boolean active) {
        userRolService.changeStatus(userId, rolId, active);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}")
    public ResponseEntity<UserRolDTO> create(@PathVariable final Long userId,
                                           @PathVariable final Integer rolId) throws URISyntaxException {
        UserRolDTO userRolDTO = userRolService.create(userId, rolId);
        return ResponseEntity
                .created(new URI("/v1/roles/"+userRolDTO.getRol().getId()+"/users/"+userRolDTO.getUser().getId())).body(userRolDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable final Long userId,
                                             @PathVariable final Integer rolId) {
        userRolService.delete(userId, rolId);
        return ResponseEntity.noContent().build();
    }
}
