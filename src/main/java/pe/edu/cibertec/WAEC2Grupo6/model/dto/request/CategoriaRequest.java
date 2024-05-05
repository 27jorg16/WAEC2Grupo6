package pe.edu.cibertec.WAEC2Grupo6.model.dto.request;

import lombok.Data;

import java.util.Date;

@Data
public class CategoriaRequest {
    private Integer idcategoria;
    private String nomcategoria;
    private String descripcategoria;
    private Date fechaRegistro;
    private Integer idFarmaco;
}
