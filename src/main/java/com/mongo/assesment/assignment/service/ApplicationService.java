package com.mongo.assesment.assignment.service;
import com.mongo.assesment.assignment.model.Users;
import java.util.List;

public interface ApplicationService {
    Users insertNewUserDoc(String name, String email, int age);
    List<Users> getAllData();
    Users getUserData(String userEmail);
    Users updateUserInfo(String email, int age);
    Users deleteUser(String email);
}
