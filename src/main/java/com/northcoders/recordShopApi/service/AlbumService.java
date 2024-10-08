package com.northcoders.recordShopApi.service;

import com.northcoders.recordShopApi.model.Album;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAllAlbums();
    Album insertAlbum(Album album);
    Optional<Album> getAlbumById(long id);
    Optional<Album> changeAlbum(long id, Album newVersion);
    void deleteAlbum(long id);
    List<Album> getAlbumsByYear(int year);
    List<Album> getAlbumsByYearAndAlbumName(int year, String albumName);
    List<Album> getAlbumByAlbumName(String albumName);
}
