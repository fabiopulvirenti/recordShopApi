package com.northcoders.recordShopApi.service;


import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<Author> getAllAuthors() {
        return List.of();
    }
}
