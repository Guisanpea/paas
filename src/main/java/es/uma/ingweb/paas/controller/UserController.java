package es.uma.ingweb.paas.controller;

import es.uma.ingweb.paas.entities.User;
import es.uma.ingweb.paas.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    @GetMapping
    public List<User> get() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}/contacts")
    public List<User> getContacts(@PathVariable String id) {
        return userRepository.findById(id)
              .map(User::getContacts)
              .orElse(Collections.emptyList());
    }

    @PostMapping
    public User post(@RequestBody User user) {
        List<User> persistedContacts = new ArrayList<>();
        user.getContacts()
              .forEach(c -> userRepository.findById(c.getEmail())
                    .ifPresent(persistedContacts::add));
        user.setContacts(persistedContacts);
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable String id) {
        return userRepository.findById(id)
              .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
              .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{id}")
    public User put(@PathVariable String id, @RequestBody User user) {
        user.setEmail(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userRepository.deleteById(id);
    }
}
