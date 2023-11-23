package com.diplomado.users.domain.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "status")
public class Status {
    @Id
    @SequenceGenerator(name = "status_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "status_sequence")
    private Integer id;
    @Column(name = "name_status")
    private String nameStatus;

    public Status() {
    }
}
