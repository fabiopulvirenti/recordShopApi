package com.northcoders.recordShopApi.controller;

import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/{id}")
    public ResponseEntity<Album> getAlbumById(@PathVariable long id){
        Optional<Album> albumOpt = this.albumService.getAlbumById(id);
        if(albumOpt.isPresent()){
            return new ResponseEntity<>(albumOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}




