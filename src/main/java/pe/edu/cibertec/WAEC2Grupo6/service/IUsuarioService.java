package pe.edu.cibertec.WAEC2Grupo6.service;

import pe.edu.cibertec.WAEC2Grupo6.model.bd.Usuario;

public interface IUsuarioService {
    Usuario findUserByNomUsuario(String nomusuario);
    void guardarUsuario(Usuario usuario);
    void cambiarPassword(Usuario usuario, String newPassword);
    Usuario obtenerUsuarioxId(long id);
    void actualizarUsuario(Usuario usuario);
    Usuario findUserByPassword(String password);
}
