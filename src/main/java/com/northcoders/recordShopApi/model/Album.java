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

    @Column(name = "album_title")
    private String albumName;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    Genre genre;

    @Column(name = "release_year")
    int releaseYear;


}
