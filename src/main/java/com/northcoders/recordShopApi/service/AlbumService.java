package com.northcoders.recordShopApi.service;

import com.northcoders.recordShopApi.model.Album;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album>getAllAlbums();
    Optional<Album> getAlbumById(long id);
}
