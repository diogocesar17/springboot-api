package br.com.loja.dao;

import br.com.loja.domains.CategoriaDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoriaDaoService {

    List<CategoriaDTO> listarCategorias() throws Exception;

    void novaCategoria(@RequestBody CategoriaDTO categoria) throws Exception;

    void excluirCategoria(Integer id) throws Exception;
}
