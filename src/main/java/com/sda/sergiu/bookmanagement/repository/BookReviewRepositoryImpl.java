package com.sda.sergiu.bookmanagement.repository;

import com.sda.sergiu.bookmanagement.model.Review;

public class BookReviewRepositoryImpl extends BaseRepositoryImpl<Review> implements BookReviewRepository{
    public BookReviewRepositoryImpl() {
        super(Review.class);
    }
}
