package com.northcoders.recordShopApi.service;

import com.northcoders.recordShopApi.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author>getAllAuthors();
    Author insertAuthor(Author author);
    Optional<Author> getAllAuthorById(long id);




}
