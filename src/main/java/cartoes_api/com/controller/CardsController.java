package cartoes_api.com.controller;

import cartoes_api.com.controller.dto.ClientResponse;
import cartoes_api.com.controller.dto.ClienteRequest;
import cartoes_api.com.service.CardService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/cartoes")
public class CardsController {

    @Autowired
    private CardService cardService;


    @PostMapping
    public ResponseEntity<ClientResponse> createCards(@Valid @RequestBody ClienteRequest clienteRequest) {

        ClientResponse response = cardService.getEligibleCards(clienteRequest.getCliente());

        List<ClientResponse.CartaoOfertado> eligibleCards = response.getCartaoOfertados();
        if (eligibleCards == null || eligibleCards.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(response);
    }

}
