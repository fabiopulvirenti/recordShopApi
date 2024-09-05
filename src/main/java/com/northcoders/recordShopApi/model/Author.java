package com.northcoders.recordShopApi.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="authors")
@Data  //Lombok
@NoArgsConstructor   //Lombok
@AllArgsConstructor  //Lombok
public class Author {

    @Id
    @GeneratedValue
    private long id;

    private String authorName;

//    public Author(String pinkFloyd) {
//        this.authorName = pinkFloyd;
//    }

//    public Author() {
//    }
//    public Author(String authorName) {
//        this.authorName = authorName;
//    }
}
