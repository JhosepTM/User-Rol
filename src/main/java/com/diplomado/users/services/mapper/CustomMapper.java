package com.diplomado.users.services.mapper;

public interface CustomMapper <DTO, E>{
    DTO toDto(E e);
    E toEntity(DTO dto);
}
