package com.yk.att.mtbs.movies.services;

import com.yk.att.mtbs.movies.model.Booking;
import com.yk.att.mtbs.movies.model.Movie;
import com.yk.att.mtbs.movies.model.MtbsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class JpaHelper<T extends MtbsEntity<T>> {

    public boolean softDelete(int id, JpaRepository<T, Integer> repository) {
        try {
            T entityToDelete = repository.findById(id).orElseThrow();
            T updatedEntity = entityToDelete.copy(true);
            repository.save(updatedEntity);
            return true;
        }
        catch(Exception exc) {
            return false;
        }
    }

    public T getNonDeleted(int id, JpaRepository<T, Integer> repository) {
        return repository.findById(id)
                .filter(e -> !e.getIsDeleted())
                .orElse(null);
    }

    public T saveNonDeleted(T entity, JpaRepository<T, Integer> repository) {
        T retrievedEntity = repository.findById(entity.getId()).orElseThrow();//TODO: handle exception of not found
        if(retrievedEntity.getIsDeleted()){
            throw new RuntimeException();
        }
        return repository.save(entity);
    }

    public List<T> findAllNonDeleted(JpaRepository<T, Integer> repository) {
        return repository.findAll().stream().filter(e -> !e.getIsDeleted()).toList();
    }
}
