package com.northcoders.recordShopApi.service;

import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public List<Album> getAllAlbums() {
        List<Album> AlbumList = new ArrayList<>();
        albumRepository.findAll().forEach(AlbumList::add);

        return AlbumList;
    }


    @Override
    public Optional<Album> getAlbumById(long id) {
        Optional<Album> album =this.albumRepository.findById(id);
        return album;
    }
    }



