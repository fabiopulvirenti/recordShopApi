package com.northcoders.recordShopApi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.northcoders.recordShopApi.model.Author;
import com.northcoders.recordShopApi.service.AuthorServiceImpl;
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
public class AuthorControllerTest {


    @Mock
    private AuthorServiceImpl mockAuthorServiceImpl;


    @InjectMocks
    private AuthorController authorController;
    @Autowired
    private MockMvc mockMvcController;

    private ObjectMapper mapper;


    @BeforeEach
    public void setup() {
        mockMvcController = MockMvcBuilders.standaloneSetup(authorController).build();
        mapper = new ObjectMapper();
    }


    @Test
    @DisplayName("Test method returns a list of all authors")
    public void testGetAllAuthors() throws Exception {


        List<Author> authorList = new ArrayList<>();
        authorList.add(new Author(1,"PinkFloyd"));
        authorList.add(new Author(2,"Janis Joplin"));
        authorList.add(new Author(3,"Maurizio Pollini"));
        authorList.add(new Author(4,"Dolly Parton"));

        when(mockAuthorServiceImpl.getAllAuthors()).thenReturn(authorList);
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/api/v1/authors"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].authorName").value("PinkFloyd"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].id").value(2))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].authorName").value("Janis Joplin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$[2].authorName").value("Maurizio Pollini"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].id").value(4))
                .andExpect(MockMvcResultMatchers.jsonPath("$[3].authorName").value("Dolly Parton"));
    }
}
