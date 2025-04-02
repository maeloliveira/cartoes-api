package cartoes_api.com.controller;


import cartoes_api.com.controller.dto.ClientRequestDTO;
import cartoes_api.com.controller.dto.ClientResponseDTO;
import cartoes_api.com.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@Valid @RequestBody ClientRequestDTO clientRequest) {
        ClientResponseDTO response = clientService.createClient(clientRequest);
        return ResponseEntity.ok(response);
    }
}
