package com.sda.sergiu.bookmanagement.repository;

import com.sda.sergiu.bookmanagement.model.Book;

import java.util.Optional;

public interface BookRepository extends BaseRepository<Book>{
    Optional<Book> findByTitle(String title);
}
