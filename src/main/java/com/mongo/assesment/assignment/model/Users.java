package com.mongo.assesment.assignment.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class Users {
    @Id
    String id;
    String name;
    String email;
    int age;

    public Users(String name, String email, int age){
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Users(String id, String name, String email, int age){
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
