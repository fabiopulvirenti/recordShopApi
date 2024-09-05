package com.northcoders.recordShopApi.service;

import com.northcoders.recordShopApi.model.Album;

import java.util.List;

public interface AlbumService {
    List<Album>getAllAlbums();
    Album getAlbumById(long id);
}
