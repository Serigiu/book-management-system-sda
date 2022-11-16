package com.sda.sergiu.bookmanagement.repository;

import java.util.Optional;

public interface BaseRepository<T> {
    Optional<T> findById(Integer id);

    void create(T entity);

    void update(T entity);

    void delete(T entity);

}
