package pe.edu.cibertec.WAEC2Grupo6.service;

import pe.edu.cibertec.WAEC2Grupo6.model.bd.Categoria;

import java.util.List;

public interface ICategoriaService {
    List<Categoria> listCategorias();

    void registerCategoria(Categoria categoria);
}
