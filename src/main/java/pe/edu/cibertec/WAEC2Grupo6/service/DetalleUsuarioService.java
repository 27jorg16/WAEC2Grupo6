package pe.edu.cibertec.WAEC2Grupo6.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Usuario;
import pe.edu.cibertec.WAEC2Grupo6.model.dto.security.UsuarioSecurity;

@AllArgsConstructor
@Service
public class DetalleUsuarioService implements UserDetailsService {
    private IUsuarioService iUsuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioService.findUserByNomUsuario(username);
        return autenticacionUsuario(usuario);
    }

    private UserDetails autenticacionUsuario(Usuario usuario) {
        UsuarioSecurity usuarioSecurity = new UsuarioSecurity(
                usuario.getNomusuario(),
                usuario.getPassword()
        );
        return usuarioSecurity;
    }
}
