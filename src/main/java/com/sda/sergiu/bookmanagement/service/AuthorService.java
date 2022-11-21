package com.sda.sergiu.bookmanagement.service;

import com.sda.sergiu.bookmanagement.model.Author;
import com.sda.sergiu.bookmanagement.service.eception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.eception.InvalidParameterException;

import java.util.List;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

    void updateAuthor(int authorId, String firstName, String lastName) throws InvalidParameterException, EntityNotFoundException;

    void deleteAuthor(int authorId) throws InvalidParameterException, EntityNotFoundException;

    List<Author> getAllAuthors();

}
