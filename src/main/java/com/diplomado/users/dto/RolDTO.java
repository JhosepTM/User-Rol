package com.diplomado.users.dto;

import java.io.Serializable;

public class RolDTO implements Serializable {
    private static final long serialVersionUID = 35325344564565543L;
    private Integer id;
    private String name;

    public RolDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "RolDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
