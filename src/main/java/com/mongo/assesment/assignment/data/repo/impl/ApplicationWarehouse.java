package com.mongo.assesment.assignment.data.repo.impl;

import com.mongo.assesment.assignment.data.repo.sql.UsersRepo;
import com.mongo.assesment.assignment.model.Users;
import com.mongo.assesment.assignment.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationWarehouse implements ApplicationService {
    @Autowired
    private UsersRepo usersRepo;
    @Override
    public Users insertNewUserDoc(String name, String email, int age) {
        return usersRepo.save(new Users(name, email, age));
    }
    @Override
    public List<Users> getAllData() {
        return usersRepo.findAll();
    }
    @Override
    public Users getUserData(String userEmail) {
        return usersRepo.getByEmail(userEmail);
    }
    @Override
    public Users updateUserInfo(String email, int age) {
        Users user = usersRepo.getByEmail(email);
        user.setAge(age);
        return usersRepo.save(user);
    }
    @Override
    public Users deleteUser(String email) {
        return usersRepo.deleteUserByEmail(email);
    }
}
