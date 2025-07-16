package com.yk.att.mtbs.users.mappers;

public interface Mapper<E,DTO>{
    DTO toDto(E e);
    E toModel(DTO dto);
}
