package com.diplomado.users.web.rest;

import com.diplomado.users.dto.RolDTO;
import com.diplomado.users.dto.UserTableDTO;
import com.diplomado.users.services.RolService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/v1/roles")
@Validated
public class RolController {
    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @PostMapping
    public ResponseEntity<RolDTO> create(@Valid @RequestBody final RolDTO dto) throws URISyntaxException {
        if (dto.getId() != null) {
            throw new IllegalArgumentException("I new rol cannot already have an id");
        }

        RolDTO rolDTO = rolService.save(dto);

        return ResponseEntity.created(new URI("/v1/roles/"+rolDTO.getId())).body(rolDTO);
    }

    @GetMapping
    public ResponseEntity<List<RolDTO>> listAllRoles() {
        return ResponseEntity.ok().body(rolService.listRoles());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RolDTO> getRolById(@PathVariable final Integer id) throws URISyntaxException {
        return ResponseEntity.ok()
                .body(rolService.getRolById(id)
                        .orElseThrow(()->new IllegalArgumentException("Resource nor found exception for: "+ id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RolDTO> editRol(@RequestBody final RolDTO dto,
                                          @PathVariable final Integer id) throws URISyntaxException {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Invalid rol id, null value");
        }
        if (!Objects.equals(dto.getId(),id)) {
            throw new IllegalArgumentException("Invalid id");
        }
        return ResponseEntity.ok().body(rolService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final Integer id) {
        rolService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
