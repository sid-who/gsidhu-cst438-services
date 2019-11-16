package edu.csumb.Webstore.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import edu.csumb.Webstore.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>
{
    
}