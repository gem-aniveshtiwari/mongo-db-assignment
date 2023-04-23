package com.mongo.assesment.assignment.controller;

import com.mongo.assesment.assignment.model.Users;
import com.mongo.assesment.assignment.service.UsersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ApplicationController {

    private final UsersUseCase usersUseCase;

    @GetMapping("/insert/new/data")
    public ResponseEntity<Users> insertNewData(@RequestParam(value = "name") String name,
                                               @RequestParam(value = "email") String email,
                                               @RequestParam(value = "age") int age){
        return ResponseEntity.ok(usersUseCase.execute(name, email, age));
    }

    @GetMapping("/get/all/data")
    public ResponseEntity<List<Users>> getData(){
        return ResponseEntity.ok(usersUseCase.execute());
    }

    @GetMapping("/get/user")
    public ResponseEntity<Users> getUserData(@RequestParam(value = "email") String userEmail){
        return ResponseEntity.ok(usersUseCase.execute(userEmail));
    }
    @GetMapping("/update/user")
    public ResponseEntity<Users> updateUserInfo(@RequestParam(value = "email") String email,
                                                @RequestParam(value = "age") int age){
        return ResponseEntity.ok(usersUseCase.update(email, age));
    }
    @GetMapping("/delete/user")
    public ResponseEntity<Users> deleteUser(@RequestParam(value = "email") String email){
        return ResponseEntity.ok(usersUseCase.delete(email));
    }
}
