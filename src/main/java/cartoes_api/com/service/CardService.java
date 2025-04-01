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

    public ClientResponse getEligibleCards(ClienteRequest.Cliente clientCards) {

        calculateAge(clientCards);

//        if (clientCards.getAge() < 18) {
//            throw new IdadeInvalidaException("O cliente deve ter 18 anos ou mais para solicitar um cartão.");
//        }

        List<ClientResponse.CartaoOfertado> eligibleCards = new ArrayList<>();

        if (clientCards.getAge() > 18 && clientCards.getAge() < 25) {
            eligibleCards.add(createCardOffer(CardType.CARTAO_SEM_ANUIDADE));
            return new ClientResponse(UUID.randomUUID(), LocalDate.now().atStartOfDay(), clientCards, eligibleCards);
        }

        if ("SP".equalsIgnoreCase(clientCards.uf)) {
            eligibleCards.add(createCardOffer(CardType.CARTAO_SEM_ANUIDADE));
            eligibleCards.add(createCardOffer(CardType.CARTAO_COM_CASHBACK));

            if (clientCards.getAge() > 25 && clientCards.getAge() < 30) {
                eligibleCards.add(createCardOffer(CardType.CARTAO_DE_PARCEIROS));
            }
        }
        return new ClientResponse(UUID.randomUUID(), LocalDate.now().atStartOfDay(), clientCards, eligibleCards);

    }

    private ClientResponse.CartaoOfertado createCardOffer(CardType cardType) {
        double valorAnuidadeMensal = 0.0;
        double valorLimiteDisponivel = 0.0;
        String status = "APROVADO";

        switch (cardType) {
            case CARTAO_SEM_ANUIDADE:
                valorAnuidadeMensal = 0.00;
                valorLimiteDisponivel = 1000.00;
                break;
            case CARTAO_COM_CASHBACK:
                valorAnuidadeMensal = 0.00;
                valorLimiteDisponivel = 5000.00;
                break;
            case CARTAO_DE_PARCEIROS:
                valorAnuidadeMensal = 20.00;
                valorLimiteDisponivel = 5000.00;
                break;
        }

        return new ClientResponse.CartaoOfertado(cardType, valorAnuidadeMensal, valorLimiteDisponivel, status);
    }

    private void calculateAge(ClienteRequest.Cliente clientCards) {
        if (clientCards.birthDate != null) {
            long years = ChronoUnit.YEARS.between(clientCards.getBirthDate(), LocalDate.now());
            clientCards.setAge((int) years);
        }
    }
}
