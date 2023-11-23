package com.diplomado.users.repositories;

import com.diplomado.users.domain.entities.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTableRepository extends JpaRepository<UserTable, Long> {
}
