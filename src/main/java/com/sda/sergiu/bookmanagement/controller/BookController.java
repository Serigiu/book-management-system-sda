package com.sda.sergiu.bookmanagement.controller;

import com.sda.sergiu.bookmanagement.service.BookService;
import com.sda.sergiu.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.exception.InvalidParameterException;

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
        } catch (Exception e){
            System.out.println("Internal server error!");
        }

    }
}
