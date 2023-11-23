package com.diplomado.users.repositories;

import com.diplomado.users.domain.entities.UserRol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolRepository extends JpaRepository<UserRol, Integer> {
    List<UserRol> findAllByUserIdOrderById(Long user_id);
    List<UserRol> findAllByRolIdOrderById(Integer rol_id);
    UserRol findFirstByUserIdAndRolId(Long user_id, Integer rol_id);
    void deleteUserRolByUserIdAndRolId(Long user_id, Integer rol_id);
}
