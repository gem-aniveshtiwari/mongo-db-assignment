package com.mongo.assesment.assignment.controller;

import com.mongo.assesment.assignment.model.Users;
import com.mongo.assesment.assignment.service.UsersUseCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(ApplicationController.class)
public class ApplicationControllerTest {
    @Inject
    private MockMvc mvc;
    @MockBean
    UsersUseCase usersUseCase;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Before
    public void setup(){
        mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    private static final Users user = new Users("Alpha123", "Anivesh Tiwari", "anivesh.tiwari", 26);
    @Test
    public void itShouldTestInsert() throws Exception {
        String email = "anivesh.tiwari";
        String name = "Anivesh Tiwari";
        int age = 26;
        Mockito.when(usersUseCase.execute(name, email, age)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.get("/api/insert/new/data").param("name", "Anivesh Tiwari")
                .param("email", "anivesh.tiwari").param("age", "26"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("anivesh.tiwari"))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Anivesh Tiwari"))
                .andReturn();
    }
    @Test
    public void itShouldGetAllData() throws Exception {
        Mockito.when(usersUseCase.execute()).thenReturn(List.of(user));
        mvc.perform(MockMvcRequestBuilders.get("/api/get/all/data"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Anivesh Tiwari"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].email").value("anivesh.tiwari"))
                .andReturn();

    }
    @Test
    public void itShouldGetUserData() throws Exception {
        Mockito.when(usersUseCase.execute("anivesh.tiwari")).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.get("/api/get/user").param("email", "anivesh.tiwari"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Anivesh Tiwari"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("anivesh.tiwari"))
                .andReturn();
    }
    @Test
    public void itShouldUpdateUser() throws Exception{
        user.setAge(30);
        Mockito.when(usersUseCase.update("anivesh.tiwari", 30)).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.get("/api/update/user").param("email", "anivesh.tiwari")
                .param("age", "30"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value("Alpha123"))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Anivesh Tiwari"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("anivesh.tiwari"))
                .andExpect(MockMvcResultMatchers.jsonPath("age").value(30))
                .andReturn();
    }

    @Test
    public void itShouldDeleteUser() throws Exception{
        Mockito.when(usersUseCase.delete("anivesh.tiwari")).thenReturn(user);
        mvc.perform(MockMvcRequestBuilders.get("/api/delete/user").param("email", "anivesh.tiwari"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id").value("Alpha123"))
                .andExpect(MockMvcResultMatchers.jsonPath("name").value("Anivesh Tiwari"))
                .andExpect(MockMvcResultMatchers.jsonPath("email").value("anivesh.tiwari"))
                .andReturn();
    }
}
