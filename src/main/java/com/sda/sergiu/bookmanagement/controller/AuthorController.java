package com.sda.sergiu.bookmanagement.controller;

import com.sda.sergiu.bookmanagement.service.AuthorService;
import com.sda.sergiu.bookmanagement.service.eception.InvalidParameterException;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class AuthorController {
    private final AuthorService authorService;
    private final Scanner scanner = new Scanner(System.in);

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public void createAuthor() {
        try {
            System.out.println("Please insert author first name: ");
            String firstName = scanner.nextLine();
            System.out.println("Please insert author last name: ");
            String lastName = scanner.nextLine();
            authorService.createAuthor(firstName, lastName);
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception ex) {
            System.out.println("Internal server error!!!");
        }

    }

    public void showAllAuthors() {
        authorService.getAllAuthors().stream().forEach(author ->
                System.out.println("Author with id: " + author.getId() + " lastname: " + author.getLastname() + " firstname: " + author.getLastname())
        );
    }

}
