package pe.edu.cibertec.WAEC2Grupo6.controller.backoffice;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Categoria;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Farmaco;
import pe.edu.cibertec.WAEC2Grupo6.model.dto.request.CategoriaRequest;
import pe.edu.cibertec.WAEC2Grupo6.model.dto.response.CategoriaResponse;
import pe.edu.cibertec.WAEC2Grupo6.service.ICategoriaService;

import java.util.List;

@AllArgsConstructor
@Controller
@RequestMapping("/categoria")
public class CategoriaController {

    private ICategoriaService iCategoriaService;

    @GetMapping("")
    public String frmCategoria(Model model){
        model.addAttribute("listarcategoria", iCategoriaService.listarCategorias());
        return "backoffice/categoria/frmcategoria";
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Categoria> listarCategoria(){
        return iCategoriaService.listarCategorias();
    }


    @PostMapping("/register")
    @ResponseBody
    public CategoriaResponse registerCategoria(@RequestBody CategoriaRequest categoriaRequest) {
        String mensaje = "Categoría registrada correctamente";
        boolean respuesta = true;
        try {
            Categoria categoria = new Categoria();
            if (categoriaRequest.getIdcategoria() > 0) {
                categoria.setIdcategoria(categoriaRequest.getIdcategoria());
            }
            categoria.setNomcategoria(categoriaRequest.getNomcategoria());
            categoria.setDescripcategoria(categoriaRequest.getDescripcategoria());
            categoria.setFechaRegistro(categoriaRequest.getFechaRegistro());

            Farmaco farmaco = new Farmaco();
            farmaco.setIdFarmaco(categoriaRequest.getIdFarmaco());
            categoria.setFarmaco(farmaco);
            iCategoriaService.registerCategoria(categoria);
        } catch (Exception ex) {
            mensaje = "Categoría no registrada, error en la BD.";
            respuesta = false;
        }
        return CategoriaResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
    }


}
