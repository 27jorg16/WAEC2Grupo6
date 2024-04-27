package pe.edu.cibertec.WAEC2Grupo6.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Usuario;
import pe.edu.cibertec.WAEC2Grupo6.repository.UsuarioRepository;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
    private UsuarioRepository usuarioRepository;
    private PasswordEncoder passwordEncoder;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Override
    public Usuario findUserByNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public void guardarUsuario(Usuario usuario) {
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioRepository.save(usuario);
    }

    @Override
    public void cambiarPassword(Usuario usuario, String newPassword) {
        usuario.setPassword(passwordEncoder.encode(newPassword));
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioxId(long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        usuario.setPassword("");
        return usuario;
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioRepository.actualizarUsuario(
                usuario.getNombres(), usuario.getApellidos(),
                usuario.getActivo(), usuario.getIdusuario()
        );
    }

    @Override
    public Usuario findUserByPassword(String password) {
        return usuarioRepository.findByPassword(password);
    }
}
