package pe.edu.cibertec.WAEC2Grupo6.controller.backoffice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Usuario;
import pe.edu.cibertec.WAEC2Grupo6.model.dto.security.UsuarioSecurity;
import pe.edu.cibertec.WAEC2Grupo6.service.IUsuarioService;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {
    private IUsuarioService iUsuarioService;

    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/frmlogin";
    }
    @PostMapping("/login")
    public String validarLogin(@ModelAttribute("usuario") Usuario usuario,
                               Model model,
                               @RequestParam("nomusuario") String nomusuario,
                               @RequestParam("password") String password) {
        if(iUsuarioService.findUserByNomUsuario(nomusuario).equals(nomusuario) &&
           iUsuarioService.findUserByPassword(password).equals(password)){
            model.addAttribute("mensaje","BIENVENIDO: " + usuario.getNomusuario());
            return "backoffice/auth/home";
        }
        model.addAttribute("mensaje","Usuario y/o password incorrecto");
        return "redirect:/auth/frmlogin";
    }

    @GetMapping("/registro")
    public String mostrarRegistroUsuario(Model model){
        model.addAttribute("usuario",new Usuario());
        return "backoffice/auth/frmregistro";
    }
    @PostMapping("registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        iUsuarioService.guardarUsuario(usuario);
        return "redirect:/auth/frmlogin";
    }

    @GetMapping("/cambiar-password")
    public String mostrarCambiarPassword(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "backoffice/auth/frmNewPassword";
    }

    @PostMapping("/cambiar-password")
    public String cambiarPassword(@ModelAttribute("usuario") Usuario usuario, @RequestParam("newPassword") String newPassword) {
        iUsuarioService.cambiarPassword(usuario, newPassword);
        return "redirect:/auth/frmlogin";
    }

    @GetMapping("/login-done")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        UsuarioSecurity usuarioSecurity = (UsuarioSecurity) userDetails;
        session.setAttribute("nomusuario", usuarioSecurity.getUsername());
        return "backoffice/auth/home";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/auth/frmlogin";
    }

    public String validarPassword(){

    }
}
