package com.northcoders.recordShopApi.service;


import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Override
    public Author insertAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Optional<Author> getAllAuthorById(long id) {
        Optional<Author> author =this.authorRepository.findById(id);
        return author;
    }


    }



