package pe.edu.cibertec.WAEC2Grupo6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.WAEC2Grupo6.model.bd.Categoria;
import pe.edu.cibertec.WAEC2Grupo6.repository.CategoriaRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class CategoriaService implements ICategoriaService{
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public void registerCategoria(Categoria categoria) {
        categoriaRepository.save(categoria);
    }
}
