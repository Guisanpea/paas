package es.uma.ingweb.paas.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Message {
    @Id
    private String id;
    private String senderEmail;
    private String receiverEmail;
    private LocalDateTime time;
    private String message;
}
