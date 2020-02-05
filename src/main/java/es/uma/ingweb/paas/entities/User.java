package es.uma.ingweb.paas.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class User {
    @Id
    private String email;

    @EqualsAndHashCode.Exclude
    private List<User> contacts;
}
