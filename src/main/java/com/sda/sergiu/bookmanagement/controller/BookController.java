package com.sda.sergiu.bookmanagement.controller;

import com.sda.sergiu.bookmanagement.service.BookService;
import com.sda.sergiu.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.exception.InvalidParameterException;

import java.io.IOException;
import java.util.Scanner;

public class BookController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    public void createBook() {
        try {
            System.out.println("Please insert a title!");
            String title = scanner.nextLine();
            System.out.println("Please insert a description!");
            String description = scanner.nextLine();
            System.out.println("Please insert an author id");
            int authorId = Integer.parseInt(scanner.nextLine());

            bookService.createBook(title, description, authorId);
            System.out.printf("Book was created!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid numeric value for author id!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error!");
        }

    }

    public void updateBook() {
        try {
            System.out.println("Please insert a book id!");
            int bookId = Integer.parseInt((scanner.nextLine()));
            System.out.println("Please insert a new book title!");
            String title = scanner.nextLine();
            System.out.println("Please insert a new book description");
            String description = scanner.nextLine();
            System.out.println("Please insert an author id!");
            int authorId = Integer.parseInt(scanner.nextLine());
            bookService.updateBook(bookId, title, description, authorId);
        } catch (NumberFormatException e) {
            System.out.println("Provided id is not a number!");
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error");
        }
    }

    public void deleteBook() {
        try {
            System.out.println("Please insert book id!");
            int bookId = Integer.parseInt(scanner.nextLine());
            bookService.deleteBook(bookId);
            System.out.println("Book with id " + bookId + " was successfully deleted");
        } catch (NumberFormatException e) {
            System.out.println("Provided book id is not a number!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Internal server error");
        }
    }

    public void importBooks() {
        try {
            System.out.println("Books imported started!");
            bookService.importBooks();
            System.out.println("Books import is finished.");
        } catch (IOException e) {
            System.out.println("Internal server error. Import failed!");
        }
    }

    public void showAllBooks() {
        bookService.getAllBooks().stream().forEach(book ->
                System.out.println(
                        "Book id: " + book.getId()
                                + " title " + book.getTitle()
                                + " author " + book.getAuthor().getFirstname()
                                + " " + book.getAuthor().getLastname()
                )
        );
    }
}