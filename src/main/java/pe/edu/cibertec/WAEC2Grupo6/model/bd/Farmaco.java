package pe.edu.cibertec.WAEC2Grupo6.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Farmaco")
public class Farmaco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFarmaco")
    private Integer idFarmaco;

    @Column(name = "NomFarmaco")
    private String nomFarmaco;

    @Column(name = "Composicion")
    private String composicion;

    @Column(name = "FechaVencimiento")
    private Date fechaVencimiento;
}
