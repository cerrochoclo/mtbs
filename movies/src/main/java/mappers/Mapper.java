package mappers;

public interface Mapper<E,DTO>{
    DTO toDto(E e);
    E toModel(DTO dto);
}
