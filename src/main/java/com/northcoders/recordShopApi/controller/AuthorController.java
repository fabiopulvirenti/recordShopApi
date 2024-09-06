package com.northcoders.recordShopApi.controller;


import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author>getAllAuthors(){
        return authorService.getAllAuthors();
    }


}


