package pe.edu.cibertec.WAEC2Grupo6.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IdCategoria")
    private Long idCategoria;

    @Column(name = "NomCategoria")
    private String nomCategoria;

    @Column(name = "DescripCategoria")
    private String descripCategoria;

    @Column(name = "FechaRegistro")
    private Date fechaRegistro;

    @ManyToOne
    @JoinColumn(name = "IdFarmaco")
    private Farmaco farmaco;
}
