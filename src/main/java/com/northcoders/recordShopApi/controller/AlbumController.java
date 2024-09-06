package com.northcoders.recordShopApi.controller;

import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable long id){
        Optional<Album> albumOpt = this.albumService.getAlbumById(id);
        if(albumOpt.isPresent()){
            return new ResponseEntity<>(albumOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping({"/albums"})
    public ResponseEntity<Album> addAuthor(@RequestBody Album album){
        Album newAlbum = albumService.insertAlbum(album);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("authors", "/api/v1/albums/" + newAlbum.getId());
        return new ResponseEntity<>(newAlbum, httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/albums/{id}")
    public ResponseEntity<Album> updateBook(@PathVariable Long id, @RequestBody Album album){
        Optional<Album> newVersionOpt = this.albumService.changeAlbum(id, album);
        if(newVersionOpt.isPresent()){
            return new ResponseEntity<>(newVersionOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}




