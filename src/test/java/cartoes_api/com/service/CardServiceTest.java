package cartoes_api.com.service;


import cartoes_api.com.controller.dto.ClientResponse;
import cartoes_api.com.exception.IdadeInvalidaException;
import cartoes_api.com.model.CardType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static cartoes_api.com.controller.dto.ClienteRequest.*;
import static org.junit.jupiter.api.Assertions.*;
public class CardServiceTest {

    private CardService cardService;

    @BeforeEach
    void setUp() {
        cardService = new CardService();
    }

    @Test
    void shouldThrowExceptionWhenClientIsUnderage() {
        Cliente underageClient = new Cliente();
        underageClient.setBirthDate(LocalDate.now().minusYears(17));

        assertThrows(IdadeInvalidaException.class, () -> cardService.getEligibleCards(underageClient));
    }

    @Test
    void shouldReturnBasicCardForClientBetween18And25() {
        Cliente youngClient = new Cliente();
        youngClient.setBirthDate(LocalDate.now().minusYears(20));
        youngClient.setUf("RJ");

        ClientResponse response = cardService.getEligibleCards(youngClient);

        assertFalse(response.getCartaoOfertados().isEmpty());
        assertEquals(1, response.getCartaoOfertados().size());
        assertEquals(CardType.CARTAO_SEM_ANUIDADE, response.getCartaoOfertados().get(0).getTipoCartao());
    }

    @Test
    void shouldReturnMoreCardsForClientsFromSP() {
        Cliente clientFromSP = new Cliente();
        clientFromSP.setBirthDate(LocalDate.now().minusYears(22));
        clientFromSP.setUf("SP");

        ClientResponse response = cardService.getEligibleCards(clientFromSP);

        assertFalse(response.getCartaoOfertados().isEmpty());
        assertEquals(3, response.getCartaoOfertados().size());
        assertTrue(response.getCartaoOfertados().stream().anyMatch(c -> c.getTipoCartao() == CardType.CARTAO_SEM_ANUIDADE));
        assertTrue(response.getCartaoOfertados().stream().anyMatch(c -> c.getTipoCartao() == CardType.CARTAO_COM_CASHBACK));
    }

    @Test
    void shouldReturnPartnerCardForClientsFromSPBetween25And30() {
        Cliente clientFromSP = new Cliente();
        clientFromSP.setBirthDate(LocalDate.now().minusYears(28));
        clientFromSP.setUf("SP");

        ClientResponse response = cardService.getEligibleCards(clientFromSP);

        assertEquals(3, response.getCartaoOfertados().size());
        assertTrue(response.getCartaoOfertados().stream().anyMatch(c -> c.getTipoCartao() == CardType.CARTAO_DE_PARCEIROS));
    }

}
