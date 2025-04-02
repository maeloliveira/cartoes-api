package cartoes_api.com.service;

import cartoes_api.com.controller.dto.ClientRequestDTO;
import cartoes_api.com.controller.dto.ClientResponseDTO;
import cartoes_api.com.producer.ClientProducer;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService {

    private final ClientProducer clientProducer;

    public ClientService(ClientProducer clientProducer) {
        this.clientProducer = clientProducer;
    }

    public ClientResponseDTO createClient(ClientRequestDTO clientRequest) {
        UUID clientId = UUID.randomUUID();

        clientProducer.sendClientCreatedEvent(clientId, clientRequest);

        ClientResponseDTO response = new ClientResponseDTO();
        response.setIdCliente(clientId);
        return response;
    }
}
