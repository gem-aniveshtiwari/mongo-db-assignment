package com.mongo.assesment.assignment.UserUseCaseTest;

import com.mongo.assesment.assignment.model.Users;
import com.mongo.assesment.assignment.service.UsersUseCase;
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
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserUseCaseTest {
    @Autowired
    UsersUseCase usersUseCase;
    @Test
    @Order(1)
    public void itShouldInsertNewUserDoc(){
        Users user = usersUseCase.execute("Anivesh Tiwari", "anivesh.tiwari", 26);
        Assertions.assertThat(user.getAge()).isEqualTo(26);
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
    @Test
    @Order(2)
    public void itShouldGetAllData(){
        List<Users> user = usersUseCase.execute();
        Assertions.assertThat(user.size()).isGreaterThan(0);
    }
    @Test
    @Order(3)
    public void itShouldGetUserData(){
        Users user = usersUseCase.execute("anivesh.tiwari");
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
    @Test
    @Order(4)
    public void itShouldUpdateUserInfo(){
        Users user = usersUseCase.update("anivesh.tiwari", 20);
        Assertions.assertThat(user.getAge()).isEqualTo(20);
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
    @Test
    @Order(5)
    public void itShouldDeleteUser(){
        Users user = usersUseCase.delete("anivesh.tiwari");
        Assertions.assertThat(user.getAge()).isEqualTo(20);
        Assertions.assertThat(user.getName()).isEqualToIgnoringCase("Anivesh Tiwari");
        Assertions.assertThat(user.getEmail()).isEqualToIgnoringCase("anivesh.tiwari");
    }
}
