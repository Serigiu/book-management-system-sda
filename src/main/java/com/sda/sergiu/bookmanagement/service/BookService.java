package com.sda.sergiu.bookmanagement.service;

import com.sda.sergiu.bookmanagement.model.Book;
import com.sda.sergiu.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.exception.InvalidParameterException;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException;

    void updateBook(int bookId, String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException;

    void deleteBook(int bookId) throws InvalidParameterException, EntityNotFoundException;

    void importBooks() throws IOException;

    List<Book> getAllBooks();
}
