package pe.edu.cibertec.WAEC2Grupo6.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategoria")
    private Integer idcategoria;

    @Column(name = "NomCategoria")
    private String nomcategoria;

    @Column(name = "DescripCategoria")
    private String descripcategoria;

    @Column(name = "FechaRegistro")
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "IdFarmaco")
    private Farmaco farmaco;
}
