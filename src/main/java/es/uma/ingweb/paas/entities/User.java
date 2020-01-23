package es.uma.ingweb.paas.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class User {
    @Id
    private String id;
    private String name;
    private String email;
}
