package pe.edu.cibertec.WAEC2Grupo6.model.dto.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;


public class UsuarioSecurity extends User {


    public UsuarioSecurity(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public UsuarioSecurity(String username, String password) {
        super(username, password, null);
    }
}
