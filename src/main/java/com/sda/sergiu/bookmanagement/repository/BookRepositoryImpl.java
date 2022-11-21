package com.sda.sergiu.bookmanagement.repository;

import com.sda.sergiu.bookmanagement.model.Book;

public class BookRepositoryImpl extends BaseRepositoryImpl<Book> implements BookRepository {
    public BookRepositoryImpl() {
        super(Book.class);
    }
}
