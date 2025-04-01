package cartoes_api.com.controller;

import cartoes_api.com.controller.dto.ClientResponse;
import cartoes_api.com.controller.dto.ClienteRequest;
import cartoes_api.com.exception.IdadeInvalidaException;
import cartoes_api.com.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cartoes")
public class CardsController {

    @Autowired
    private CardService cardService;


    @PostMapping
    public ResponseEntity<ClientResponse> createCards(@RequestBody ClienteRequest clienteRequest){

        if (clienteRequest.getCliente().getAge() < 18) {
            throw new IdadeInvalidaException("O cliente deve ter 18 anos ou mais para solicitar um cartão.");
        }

        List<ClientResponse.CartaoOfertado> eligibleCards = (List<ClientResponse.CartaoOfertado>) cardService.getEligibleCards(clienteRequest.getCliente());

        if (eligibleCards.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ClienteRequest.Cliente cliente = new ClienteRequest.Cliente(
                clienteRequest.getCliente().getName(),
                clienteRequest.getCliente().getCpf(),
                clienteRequest.getCliente().getAge(),
                clienteRequest.getCliente().getBirthDate(),
                clienteRequest.getCliente().getUf(),
                clienteRequest.getCliente().getMonthPayment(),
                clienteRequest.getCliente().getEmail(),
                clienteRequest.getCliente().getPhone()
        );

//        ClientResponse response = new ClientResponse(
//                cliente,
//                clienteRequest.getCliente().datas
//                clienteRequest.getCliente(),
//                eligibleCards
//        );



        ClientResponse response1 = cardService.getEligibleCards(clienteRequest.getCliente());

        return new ResponseEntity<>(response1, HttpStatus.OK);
    }
}
