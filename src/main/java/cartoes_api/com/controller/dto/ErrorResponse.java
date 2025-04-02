package cartoes_api.com.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ErrorResponse {

    private String codigo;
    private String mensagem;
    private DetalheErro detalheErro;

    public ErrorResponse(String codigo, String mensagem, DetalheErro detalheErro) {
        this.codigo = codigo;
        this.mensagem = mensagem;
        this.detalheErro = detalheErro;
    }

    @Data
    public static class DetalheErro {
        private String app;
        private String tipoErro;
        private String mensagemInterna;


        public DetalheErro(String app, String tipoErro, String mensagemInterna) {
            this.app = app;
            this.tipoErro = tipoErro;
            this.mensagemInterna = mensagemInterna;
        }
    }
}
