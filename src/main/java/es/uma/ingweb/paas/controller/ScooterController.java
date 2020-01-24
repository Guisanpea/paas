package es.uma.ingweb.paas.controller;

import es.uma.ingweb.paas.entities.Scooter;
import es.uma.ingweb.paas.entities.User;
import es.uma.ingweb.paas.repositories.ScooterRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.stream.IntStream;

@RequestMapping("/scooters")
@AllArgsConstructor
public class ScooterController {
    private final ScooterRepository scooterRepository;

    @PostMapping("/init")
    public void init() {
        IntStream.range(0, 5)
              .forEach(i -> {
                  Scooter scooter = Scooter.builder()
                        .latitude(36.7175003)
                        .longitude(-4.4207582)
                        .build();
                  scooterRepository.insert(scooter);
              });
    }
}
