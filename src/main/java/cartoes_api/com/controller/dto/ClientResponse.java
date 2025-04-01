package cartoes_api.com.controller.dto;

import cartoes_api.com.model.CardType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ClientResponse {

    public ClientResponse(UUID numeroSolicitacao,
                          LocalDateTime dataSolicitacao,
                          ClienteRequest.Cliente clientCards,
                          List<CartaoOfertado> cartaoOfertados) {
    }

    @Data
    public static class CartaoOfertado {
        private CardType tipoCartao;
        private double valorAnuidadeMensal;
        private double valorLimiteDisponivel;
        private String status;

        public CartaoOfertado(CardType tipoCartao, double valorAnuidadeMensal, double valorLimiteDisponivel, String status) {
            this.tipoCartao = tipoCartao;
            this.valorAnuidadeMensal = valorAnuidadeMensal;
            this.valorLimiteDisponivel = valorLimiteDisponivel;
            this.status = status;
        }
    }
}
