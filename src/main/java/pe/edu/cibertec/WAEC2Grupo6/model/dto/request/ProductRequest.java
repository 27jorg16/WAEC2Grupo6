package pe.edu.cibertec.WAEC2Grupo6.model.dto.request;

import lombok.Data;

@Data
public class ProductRequest {
    private Integer productid;
    private String productname;
    private Double unitprice;
    private Boolean discontinued;
    private Integer supplierid;
    private Integer categoryid;
}
