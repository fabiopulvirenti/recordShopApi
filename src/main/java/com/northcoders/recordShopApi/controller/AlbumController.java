package com.northcoders.recordShopApi.controller;

import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AlbumController {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/albums")
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }
}


