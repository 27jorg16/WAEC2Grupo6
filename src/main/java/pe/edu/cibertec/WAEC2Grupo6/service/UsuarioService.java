package pe.edu.cibertec.WAEC2Grupo6.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Usuario;
import pe.edu.cibertec.WAEC2Grupo6.repository.RolRepository;
import pe.edu.cibertec.WAEC2Grupo6.repository.UsuarioRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public Usuario findUserByNomUsuario(String nomusuario) {
        return null;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return null;
    }

    @Override
    public Usuario obtenerUsuarioxId(int id) {
        return null;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {

    }
}
