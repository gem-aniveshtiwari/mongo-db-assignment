package com.mongo.assesment.assignment.data.repo.sql;

import com.mongo.assesment.assignment.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
public interface UsersRepo extends MongoRepository<Users, String> {
    @Query("{email: ?0}")
    Users getByEmail(String userEmail);
    @Query(value = "{email: ?0}", delete = true)
    Users deleteUserByEmail(String email);

    ;
}
