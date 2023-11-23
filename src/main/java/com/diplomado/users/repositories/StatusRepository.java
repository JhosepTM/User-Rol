package com.diplomado.users.repositories;

import com.diplomado.users.domain.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
