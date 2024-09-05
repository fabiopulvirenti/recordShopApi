package com.northcoders.recordShopApi.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="albums")
@Data  //Lombok
@NoArgsConstructor   //Lombok
@AllArgsConstructor  //Lombok
public class Album {

    @Id
    @GeneratedValue
    private long id;

    private String album_title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    Genre genre;

    int release_year;


}
