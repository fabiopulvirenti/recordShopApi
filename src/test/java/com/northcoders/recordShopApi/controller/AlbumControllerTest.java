package com.northcoders.recordShopApi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.recordShopApi.model.Album;
import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.model.Genre;
import com.northcoders.recordShopApi.service.AlbumServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@AutoConfigureMockMvc
@SpringBootTest
public class AlbumControllerTest {

    @Mock
    private AlbumServiceImpl mockAlbumServiceImpl;

    @InjectMocks
    private AlbumController albumController;

    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;

    @BeforeEach
    public void setup(){
        mockMvcController = MockMvcBuilders.standaloneSetup(albumController).build();
        mapper = new ObjectMapper();
    }

    @Test
    @DisplayName("Test method returns a list of all albums")
    public void testGetAllAlbums() throws Exception{

        Author author1 = new Author("PinkFloyd");
        Author author2 = new Author("Janis Joplin");
        Author author3 = new Author("Maurizio Pollini");
        Author author4 = new Author("Dolly Parton");
        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album(1L,"the Wall",author1, Genre.Rock,1979));
        albumList.add(new Album(2L,"Pearl",author2, Genre.Blues,1972));
        albumList.add(new Album(3L,"Chopin Etudes",author3, Genre.Classical_music,1973));
        albumList.add(new Album(4L,"Those were the days",author4, Genre.Country_music,2005));


        when(mockAlbumServiceImpl.getAllAlbums()).thenReturn(albumList);
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/api/v1/albums"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].album_title").value("the Wall"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].album_title").value("Pearl"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].album_title").value("Chopin Etude"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].album_title").value("Those were the days"));
    }



}














