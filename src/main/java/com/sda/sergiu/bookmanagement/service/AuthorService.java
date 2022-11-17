package com.sda.sergiu.bookmanagement.service;

import com.sda.sergiu.bookmanagement.service.eception.InvalidParameterException;

public interface AuthorService {

    void createAuthor(String firstName, String lastName) throws InvalidParameterException;

}
