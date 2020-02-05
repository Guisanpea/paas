package es.uma.ingweb.paas.repositories;

import es.uma.ingweb.paas.entities.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, Integer> {
    List<Message> findAllBySenderEmailAndReceiverEmail(String senderEmail, String receiverEmail);
}
