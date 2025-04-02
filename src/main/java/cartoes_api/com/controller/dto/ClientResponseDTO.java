package cartoes_api.com.controller.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ClientResponseDTO {
    private UUID idCliente;

    public UUID getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(UUID idCliente) {
        this.idCliente = idCliente;
    }
}
