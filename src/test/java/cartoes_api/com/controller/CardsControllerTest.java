package cartoes_api.com.controller;


import cartoes_api.com.controller.dto.ClientResponse;
import cartoes_api.com.controller.dto.ClienteRequest;
import cartoes_api.com.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CardsController.class)
public class CardsControllerTest {

    @Mock
    CardService cardService;

    @InjectMocks
    private CardsController cardsController;

    @Autowired
    private ObjectMapper objectMapper;

    private ClienteRequest validRequest;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        validRequest = new ClienteRequest();
        ClienteRequest.Cliente cliente = new ClienteRequest.Cliente();
        cliente.setName("João Silva");
        cliente.setCpf("12345678900");
        cliente.setAge(25);
        cliente.setBirthDate(LocalDate.of(1995, 6, 15));
        cliente.setUf("SP");
        cliente.setMonthPayment(BigDecimal.valueOf(5000.00));
        cliente.setEmail("joao@example.com");
        cliente.setPhone("11999999999");
        validRequest.setCliente(cliente);

        mockMvc = MockMvcBuilders.standaloneSetup(cardsController).build();
    }

//    @Test
//    void createCards_DeveRetornar200_QuandoDadosValidos() throws Exception {
//        ClientResponse response = new ClientResponse();
//        response.setCartaoOfertados(Collections.emptyList());
//        Mockito.when(cardService.getEligibleCards(any())).thenReturn(response);
//
//        mockMvc.perform(post("/cartoes")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(validRequest)))
//                .andExpect(status().isOk());
//    }

    @Test
    void createCards_DeveRetornar204_QuandoSemCartoesElegiveis() throws Exception {
        ClientResponse response = new ClientResponse();
        response.setCartaoOfertados(Collections.emptyList());

        Mockito.when(cardService.getEligibleCards(any())).thenReturn(response);

        mockMvc.perform(post("/cartoes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(validRequest)))
                .andExpect(status().isNoContent());
    }

//    @Test
//    void createCards_DeveRetornar400_QuandoNomeEhNulo() throws Exception {
//        validRequest.getCliente().setName(null);
//
//        mockMvc.perform(post("/cartoes")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(validRequest)))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.message").value("Erro de validação"))
//                .andExpect(jsonPath("$.details.codigo").value("VALIDACAO_CAMPOS"));
//    }
//
//    @Test
//    void createCards_DeveRetornar400_QuandoMonthPaymentEhNegativo() throws Exception {
//        validRequest.getCliente().setMonthPayment(BigDecimal.valueOf(-500.00));
//
//        mockMvc.perform(post("/cartoes")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(validRequest)))
//                .andExpect(status().isBadRequest())
//                .andExpect(jsonPath("$.message").value("Erro de validação"));
//    }
}
