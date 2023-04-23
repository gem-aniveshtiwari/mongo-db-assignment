package com.mongo.assesment.assignment.data.repo;

import com.mongo.assesment.assignment.data.repo.impl.ApplicationWarehouse;
import com.mongo.assesment.assignment.model.Users;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationWarehouseTest {
    @Autowired
    ApplicationWarehouse applicationWarehouse;

    @Test
    @Order(1)
    public void itShouldInsertNewUserDoc(){
        Users user = applicationWarehouse.insertNewUserDoc("Anivesh Tiwari", "anivesh.tiwari", 26);
        Assertions.assertThat(user.getAge()).isEqualTo(26);
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
    @Test
    @Order(2)
    public void itShouldGetAllData(){
        List<Users> user = applicationWarehouse.getAllData();
        Assertions.assertThat(user.size()).isGreaterThan(0);
    }
    @Test
    @Order(3)
    public void itShouldGetUserData(){
        Users user = applicationWarehouse.getUserData("anivesh.tiwari");
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
    @Test
    @Order(4)
    public void itShouldUpdateUserInfo(){
        Users user = applicationWarehouse.updateUserInfo("anivesh.tiwari", 20);
        Assertions.assertThat(user.getAge()).isEqualTo(20);
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
    @Test
    @Order(5)
    public void itShouldDeleteUser(){
        Users user = applicationWarehouse.deleteUser("anivesh.tiwari");
        Assertions.assertThat(user.getAge()).isEqualTo(20);
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
}
