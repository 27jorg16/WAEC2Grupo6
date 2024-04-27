package pe.edu.cibertec.WAEC2Grupo6.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@NoArgsConstructor
@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String nomusuario;
    private String email;
    private String password;
    private String nombres;
    private String apellidos;
    private Boolean activo;
}
