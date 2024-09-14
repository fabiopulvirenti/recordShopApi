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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;


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

        Author author1 = new Author(1,"PinkFloyd");
        Author author2 = new Author(2,"Janis Joplin");
        Author author3 = new Author(3,"Maurizio Pollini");
        Author author4 = new Author(4,"Dolly Parton");
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
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].album_title").value("Chopin Etudes"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].album_title").value("Those were the days"));
    }

    @Test
    @DisplayName("Test method returns an album by Id")
    void testGetAlbumByID() throws Exception{
        Author author1 = new Author(1,"PinkFloyd");
        Author author2 = new Author(2,"Janis Joplin");
        Author author3 = new Author(3,"Maurizio Pollini");
        Author author4 = new Author(4,"Dolly Parton");

        Album album1= new Album(1L,"the Wall",author1, Genre.Rock,1979);
        Album album2= new Album(2L,"Pearl",author2, Genre.Blues,1972);
        Album album3= new Album(3L,"Chopin Etudes",author3, Genre.Classical_music,1973);
        Album album4= new Album(4L,"Those were the days",author4, Genre.Country_music,2005);



        when(mockAlbumServiceImpl.getAlbumById(1L)).thenReturn(Optional.of(album1));
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/albums/1"))

                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.album_title").value("the Wall"));

        verify(mockAlbumServiceImpl).getAlbumById(1L);
    }

    @Test
    @DisplayName("test method checks if an album has been inserted")
    public void testPostAddAlbum() throws Exception {

        Author author1 = new Author(1,"PinkFloyd");

        Album album1= new Album(1L,"the Wall",author1, Genre.Rock,1979);

        when(mockAlbumServiceImpl.insertAlbum(album1)).thenReturn(album1);
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.post("/api/v1/albums/")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(mapper.writeValueAsString(album1)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

        verify(mockAlbumServiceImpl, times(1)).insertAlbum(album1);
    }

    @Test
    void updateAlbumByID() throws Exception {

        Long id =1L;
        Author author1 = new Author(1,"PinkFloyd");
        Author author2 = new Author(2,"Janis Joplin");

        Album albumToUpdate = new Album(id,"the Wall",author1, Genre.Rock,1979);
        Album updatedAlbum =  new Album(id,"Pearl",author2, Genre.Blues,1972);

        when(mockAlbumServiceImpl.getAlbumById(id)).thenReturn(Optional.of(updatedAlbum));
        ResponseEntity<Album> responseEntity =albumController.updateAlbum(id, albumToUpdate);

        verify(mockAlbumServiceImpl, times(1)).changeAlbum(id, albumToUpdate);

    }














}














