package es.uma.ingweb.paas.controller;

import es.uma.ingweb.paas.entities.Message;
import es.uma.ingweb.paas.repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageRepository messageRepository;

    @GetMapping
    public List<Message> get(
          @RequestParam Optional<String> senderEmail,
          @RequestParam Optional<String> receiverEmail) {
        return senderEmail.flatMap(sender -> receiverEmail.map(receiver ->
              messageRepository.findAllBySenderEmailAndReceiverEmail(
                    sender,
                    receiver
              )
        )).orElseGet(messageRepository::findAll);
    }

    @PostMapping
    public Message post(@RequestBody Message message) {
        message.setTime(LocalDateTime.now());
        return messageRepository.save(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> get(@PathVariable int id) {
        return messageRepository.findById(id)
              .map(result -> new ResponseEntity<>(result, OK))
              .orElse(new ResponseEntity<>(NOT_FOUND));
    }

    @PutMapping("/{id}")
    public Message put(@PathVariable String id, @RequestBody Message message) {
        message.setId(id);
        return messageRepository.save(message);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        messageRepository.deleteById(id);
    }
}
