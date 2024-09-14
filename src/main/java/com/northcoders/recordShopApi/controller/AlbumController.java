package com.northcoders.recordShopApi.controller;

import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumController.class);

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAllAlbums(@RequestParam(name="year",required = false) Integer releaseYear,
                                    @RequestParam(name="album_name",required=false)String albumName) {
        if(releaseYear !=null && albumName !=null) {
            return albumService.getAlbumsByYearAndAlbumName(releaseYear, albumName);
        } else if(releaseYear == null && albumName != null) {
            return albumService.getAlbumByAlbumName(albumName);
        } else if(releaseYear!=null && albumName ==null){
            return albumService.getAlbumsByYear(releaseYear);
        } else {
            return albumService.getAllAlbums();
        }
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
    public ResponseEntity<Album> updateAlbum(@PathVariable Long id, @RequestBody Album album){
        Optional<Album> newVersionOpt = this.albumService.changeAlbum(id, album);
        if(newVersionOpt.isPresent()){
            return new ResponseEntity<>(newVersionOpt.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/albums/{id}")
    public ResponseEntity<String> deleteAlbumById(@PathVariable long id){
        this.albumService.deleteAlbum(id);
        ResponseEntity<String> response = new ResponseEntity<>("Album deleted successfully", HttpStatus.OK);
        LOGGER.info("Album deleted: {}", response);

        return response;
    }


}




