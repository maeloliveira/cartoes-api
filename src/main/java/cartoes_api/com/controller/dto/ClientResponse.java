package cartoes_api.com.controller.dto;

import cartoes_api.com.model.CardType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class ClientResponse {

    private UUID numeroSolicitacao;
    private LocalDateTime dataSolicitacao;
    private ClienteRequest.Cliente clientCards;
    private List<CartaoOfertado> cartaoOfertados;

    public ClientResponse(UUID numeroSolicitacao, LocalDateTime dataSolicitacao, ClienteRequest.Cliente clientCards, List<CartaoOfertado> cartaoOfertados) {
        this.numeroSolicitacao = numeroSolicitacao;
        this.dataSolicitacao = dataSolicitacao;
        this.clientCards = clientCards;
        this.cartaoOfertados = cartaoOfertados;
    }

    public ClientResponse() {

    }

    public UUID getNumeroSolicitacao() {
        return numeroSolicitacao;
    }

    public void setNumeroSolicitacao(UUID numeroSolicitacao) {
        this.numeroSolicitacao = numeroSolicitacao;
    }

    public LocalDateTime getDataSolicitacao() {
        return dataSolicitacao;
    }

    public void setDataSolicitacao(LocalDateTime dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public ClienteRequest.Cliente getClientCards() {
        return clientCards;
    }

    public void setClientCards(ClienteRequest.Cliente clientCards) {
        this.clientCards = clientCards;
    }

    public List<CartaoOfertado> getCartaoOfertados() {
        return cartaoOfertados;
    }

    public void setCartaoOfertados(List<CartaoOfertado> cartaoOfertados) {
        this.cartaoOfertados = cartaoOfertados;
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

        public CardType getTipoCartao() {
            return tipoCartao;
        }

        public void setTipoCartao(CardType tipoCartao) {
            this.tipoCartao = tipoCartao;
        }

        public double getValorAnuidadeMensal() {
            return valorAnuidadeMensal;
        }

        public void setValorAnuidadeMensal(double valorAnuidadeMensal) {
            this.valorAnuidadeMensal = valorAnuidadeMensal;
        }

        public double getValorLimiteDisponivel() {
            return valorLimiteDisponivel;
        }

        public void setValorLimiteDisponivel(double valorLimiteDisponivel) {
            this.valorLimiteDisponivel = valorLimiteDisponivel;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
