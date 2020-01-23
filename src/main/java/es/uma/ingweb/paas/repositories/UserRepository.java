package es.uma.ingweb.paas.repositories;

import es.uma.ingweb.paas.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findUserByEmail(String email);
    List<User> findUsersByName(String name);
}
