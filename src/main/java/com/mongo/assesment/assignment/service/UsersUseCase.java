package com.mongo.assesment.assignment.service;

import com.mongo.assesment.assignment.model.Users;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
public class UsersUseCase {
    private final ApplicationService service;
    public Users execute(String name, String email, int age){
        return service.insertNewUserDoc(name, email, age);
    }
    public List<Users> execute(){
        return service.getAllData();
    }
    public Users execute(String userEmail) {
        return service.getUserData(userEmail);
    }
    public Users update(String email, int age) {
        return service.updateUserInfo(email, age);
    }
    public Users delete(String email) {
        return service.deleteUser(email);
    }
}
