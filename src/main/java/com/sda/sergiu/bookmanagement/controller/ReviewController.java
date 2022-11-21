package com.sda.sergiu.bookmanagement.controller;

import com.sda.sergiu.bookmanagement.service.BookReviewService;
import com.sda.sergiu.bookmanagement.service.exception.EntityNotFoundException;
import com.sda.sergiu.bookmanagement.service.exception.InvalidParameterException;

import java.util.Scanner;

public class ReviewController {
    private final Scanner scanner = new Scanner(System.in);
    private final BookReviewService bookReviewService;

    public ReviewController(BookReviewService bookReviewService) {
        this.bookReviewService = bookReviewService;
    }

    public void createReview() {
        try {
            System.out.println("Please insert book title");
            String title = scanner.nextLine();
            System.out.println("Please insert a score:");
            int score = Integer.parseInt(scanner.nextLine());
            System.out.println("Please insert a comment");
            String comment = scanner.nextLine();
            bookReviewService.createBookReview(title, score, comment);
        } catch (EntityNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Please insert a valid numeric value for score!");
        } catch (InvalidParameterException e) {
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("Internal server error!");
        }
    }
}
