package cartoes_api.com.service;

import cartoes_api.com.controller.dto.ClientResponse;
import cartoes_api.com.controller.dto.ClienteRequest;
import cartoes_api.com.exception.IdadeInvalidaException;
import cartoes_api.com.model.CardType;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CardService {

    public ClientResponse getEligibleCards(ClienteRequest.Cliente clientCards)
    {

        int age = calculateAge(clientCards);

        if (age < 18) {
            throw new IdadeInvalidaException();
        }

        List<ClientResponse.CartaoOfertado> eligibleCards = new ArrayList<>();

        if (age > 18 && age < 25) {
            eligibleCards.add(createCardOffer(CardType.CARTAO_SEM_ANUIDADE));
        }

        if ("SP".equalsIgnoreCase(clientCards.uf)) {
            eligibleCards.add(createCardOffer(CardType.CARTAO_SEM_ANUIDADE));
            eligibleCards.add(createCardOffer(CardType.CARTAO_COM_CASHBACK));

            if (age> 25 && age < 30) {
                eligibleCards.add(createCardOffer(CardType.CARTAO_DE_PARCEIROS));
            }
        }
        return new ClientResponse(UUID.randomUUID(), LocalDate.now().atStartOfDay(), clientCards, eligibleCards);

    }

    private ClientResponse.CartaoOfertado createCardOffer(CardType cardType) {
        double valorAnuidadeMensal = 0.0;
        double valorLimiteDisponivel = 0.0;
        String status = "APROVADO";

        valorLimiteDisponivel = switch (cardType) {
            case CARTAO_SEM_ANUIDADE -> {
                valorAnuidadeMensal = 0.00;
                yield 1000.00;
            }
            case CARTAO_COM_CASHBACK -> {
                valorAnuidadeMensal = 0.00;
                yield 5000.00;
            }
            case CARTAO_DE_PARCEIROS -> {
                valorAnuidadeMensal = 20.00;
                yield 5000.00;
            }
        };

        return new ClientResponse.CartaoOfertado(cardType, valorAnuidadeMensal, valorLimiteDisponivel, status);
    }


    private int calculateAge(ClienteRequest.Cliente clientCards) {
        if (clientCards.getBirthDate() != null) {
            return (int) ChronoUnit.YEARS.between(clientCards.getBirthDate(), LocalDate.now());
        }
        return 0;
    }

}
