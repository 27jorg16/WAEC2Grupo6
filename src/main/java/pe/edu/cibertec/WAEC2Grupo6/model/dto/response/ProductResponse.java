package pe.edu.cibertec.WAEC2Grupo6.model.dto.response;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class ProductResponse {
    private Boolean respuesta;
    private String mensaje;
}
