package com.sda.sergiu.bookmanagement.repository;

import com.sda.sergiu.bookmanagement.model.Author;

public class AuthorRepositoryImpl extends BaseRepositoryImpl<Author> implements AuthorRepository{
    public AuthorRepositoryImpl() {
        super(Author.class);
    }
}
