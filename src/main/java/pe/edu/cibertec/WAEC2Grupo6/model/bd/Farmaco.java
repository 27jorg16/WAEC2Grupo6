package pe.edu.cibertec.WAEC2Grupo6.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Farmaco")
public class Farmaco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdFarmaco")
    private Integer idfarmaco;
    @Column(name = "NomFarmaco")
    private String nomfarmaco;
    @Column(name = "Composicion")
    private String composicion;
    @Column(name = "FechaVencimiento")
    private Date fechavencimiento;
}
