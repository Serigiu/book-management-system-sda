package com.sda.sergiu.bookmanagement.service;

import com.sda.sergiu.bookmanagement.model.Author;
import com.sda.sergiu.bookmanagement.repository.AuthorRepository;
import com.sda.sergiu.bookmanagement.service.eception.InvalidParameterException;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void createAuthor(String firstName, String lastName) throws InvalidParameterException {
        if (firstName == null || firstName.isBlank() || firstName.length() < 3) {
            throw new InvalidParameterException("Provided value for first name: " + firstName + " is invalid!");
        }
        if (lastName == null || lastName.isBlank() || lastName.length() < 3) {
            throw new InvalidParameterException("Provided value for last name: " + lastName + " is invalid!");
        }

        authorRepository.create(new Author(firstName, lastName));
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
