package com.northcoders.recordShopApi.repository;

import com.northcoders.recordShopApi.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {


    List<Album> findByAlbumName(String albumName);
    List<Album> findAlbumByReleaseYear(int year);
    List<Album> findAlbumByReleaseYearAndAlbumName(int year, String albumName);

}
