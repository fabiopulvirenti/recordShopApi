package com.northcoders.recordShopApi.controller;


import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping("/authors")
    public List<Author>getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id){
        Optional<Author> authorOpt =this.authorService.getAllAuthorById(id);
        if(authorOpt.isPresent()){
            return new ResponseEntity<>(authorOpt.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping({"/authors"})
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        Author newAuthor = authorService.insertAuthor(author);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("authors", "/api/v1/authors/" + newAuthor.getId());
        return new ResponseEntity<>(newAuthor, httpHeaders, HttpStatus.CREATED);
    }


}


