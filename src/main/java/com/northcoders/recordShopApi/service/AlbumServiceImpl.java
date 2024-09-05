package com.northcoders.recordShopApi.service;

import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public Album getAlbumById(long id) {
        return null;
    }
}

