package com.northcoders.recordShopApi.service;


import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;


    @Override
    public List<Author> getAllAuthors() {
        List<Author> AuthorList = new ArrayList<>();
        authorRepository.findAll().forEach(AuthorList::add);

        return AuthorList;
    }
}
