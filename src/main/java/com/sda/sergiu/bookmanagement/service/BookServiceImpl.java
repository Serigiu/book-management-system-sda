package com.sda.sergiu.bookmanagement.service;

import com.sda.sergiu.bookmanagement.model.Author;
import com.sda.sergiu.bookmanagement.model.Book;
import com.sda.sergiu.bookmanagement.repository.AuthorRepository;
import com.sda.sergiu.bookmanagement.repository.BookRepository;
import com.sda.sergiu.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.exception.InvalidParameterException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public void createBook(String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException(" Provided value for title: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 3) {
            throw new InvalidParameterException(" Provided value for description: " + title + " is invalid");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id:" + authorId + " is invalid");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id " + authorId + " was not found!");
        }
        Author author = authorOptional.get();
        Book book = new Book(title, description);
        book.setAuthor(author);
        bookRepository.create(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void updateBook(int bookId, String title, String description, int authorId) throws InvalidParameterException, EntityNotFoundException {
        if (title == null || title.isBlank() || title.length() < 3) {
            throw new InvalidParameterException(" Provided value for title: " + title + " is invalid");
        }
        if (description == null || description.isBlank() || description.length() < 3) {
            throw new InvalidParameterException(" Provided value for description: " + title + " is invalid");
        }
        if (bookId < 1) {
            throw new InvalidParameterException("Provided value for book id:" + bookId + " is invalid");
        }
        if (authorId < 1) {
            throw new InvalidParameterException("Provided value for author id:" + authorId + " is invalid");
        }
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id " + bookId + " was not found!");
        }
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isEmpty()) {
            throw new EntityNotFoundException("Author with provided id " + authorId + " was not found!");
        }
        Book book = bookOptional.get();
        Author author = authorOptional.get();
        book.setTitle(title);
        book.setDescription(description);
        book.setAuthor(author);
        bookRepository.update(book);
    }

    @Override
    public void deleteBook(int bookId) throws InvalidParameterException, EntityNotFoundException {
        if (bookId < 1) {
            throw new InvalidParameterException("Provided value for Book id: " + bookId + " is invalid!");
        }
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        if (bookOptional.isEmpty()) {
            throw new EntityNotFoundException("Book with id: " + bookId + " was not found!");
        }
        Book book = bookOptional.get();
        bookRepository.delete(book);
    }
    @Override
    public void importBooks() throws IOException {
        Path filepath = Paths.get("C:\\Users\\User\\Documents\\book-management-system-sda\\src\\main\\resources\\Data\\Books.csv");
        Files.lines(filepath)
                .skip(1)
                .filter(line -> line != null)
                .filter(line -> !line.isBlank())
                .map(line -> line.split("\\|"))
                .forEach(bookProperties -> {
                    try {
                        String description = bookProperties[1];
                        String title = bookProperties[2];
                        int authorId = Integer.parseInt(bookProperties[3]);
                        createBook(title,description, authorId);
                    } catch (Exception e) {
                        System.err.println(e.getMessage());
                    }
                });

    }

}