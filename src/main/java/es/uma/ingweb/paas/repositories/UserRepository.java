package es.uma.ingweb.paas.repositories;

import es.uma.ingweb.paas.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
