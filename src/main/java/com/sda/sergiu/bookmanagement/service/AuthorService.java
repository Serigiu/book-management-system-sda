package com.sda.sergiu.bookmanagement.service;

import com.sda.sergiu.bookmanagement.model.Author;
import com.sda.sergiu.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.exception.InvalidParameterException;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException;

    void importAuthors() throws IOException;

    List<Author> getAllAuthors();

}
