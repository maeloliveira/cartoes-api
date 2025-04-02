package cartoes_api.com.producer;

import cartoes_api.com.controller.dto.ClientRequestDTO;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ClientProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "client-created";

    public ClientProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendClientCreatedEvent(java.util.UUID clientId, ClientRequestDTO clientRequest) {
        String event = String.format("{\"idCliente\": \"%s\", \"name\": \"%s\"}",
                clientId, clientRequest.getName());
        kafkaTemplate.send(topic, event);
    }
}
