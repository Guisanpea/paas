package es.uma.ingweb.paas.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
public class Scooter {
    @Id
    private String id;
    private double latitude;
    private double longitude;
    private boolean available;
}
