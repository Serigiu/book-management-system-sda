package com.sda.sergiu.bookmanagement;

import com.sda.sergiu.bookmanagement.controller.AuthorController;
import com.sda.sergiu.bookmanagement.controller.BookController;
import com.sda.sergiu.bookmanagement.controller.ReviewController;
import com.sda.sergiu.bookmanagement.menu.UserOption;
import com.sda.sergiu.bookmanagement.repository.AuthorRepositoryImpl;
import com.sda.sergiu.bookmanagement.repository.BookRepositoryImpl;
import com.sda.sergiu.bookmanagement.repository.BookReviewRepositoryImpl;
import com.sda.sergiu.bookmanagement.service.AuthorServiceImpl;
import com.sda.sergiu.bookmanagement.service.BookReviewServiceImpl;
import com.sda.sergiu.bookmanagement.service.BookServiceImpl;
import com.sda.sergiu.bookmanagement.utils.SessionManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SessionManager.getSessionFactory();

        AuthorController authorController = new AuthorController(new AuthorServiceImpl(new AuthorRepositoryImpl()));

        BookController bookController = new BookController(new BookServiceImpl(new BookRepositoryImpl(), new AuthorRepositoryImpl()));

        ReviewController reviewController = new ReviewController(new BookReviewServiceImpl(new BookReviewRepositoryImpl(), new BookRepositoryImpl()));

        Scanner scanner = new Scanner(System.in);

        UserOption userOption;
        do {
            UserOption.printAllOption();
            System.out.println("Please select an option!");
            try {
                int numericOption = Integer.parseInt(scanner.nextLine());
                userOption = UserOption.findUserOption(numericOption);
            } catch (NumberFormatException e) {
                userOption = UserOption.UNKNOWN;
            }

            switch (userOption) {
                case CREATE_AUTHOR:
                    authorController.createAuthor();
                    break;
                case SHOW_ALL_AUTHORS:
                    authorController.showAllAuthors();
                    break;
                case UPDATE_AUTHOR:
                    authorController.updateAuthor();
                    break;
                case DELETE_AUTHOR:
                    authorController.deleteAuthor();
                    break;
                case CREATE_BOOK:
                    bookController.createBook();
                    break;
                case SHOW_ALL_BOOKS:
                    bookController.showAllBooks();
                    break;
                case UPDATE_BOOK:
                    bookController.updateBook();
                    break;
                case DELETE_BOOK:
                    bookController.deleteBook();
                    break;
                case CREATE_REVIEW:
                    reviewController.createReview();
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                case UNKNOWN:
                    System.out.println("Option unknown!");
                    break;
                default:
                    System.out.println("User option " + userOption + " is not implemented!");
                    break;
            }

        } while (userOption != UserOption.EXIT);
        SessionManager.shutDown();

    }

}

