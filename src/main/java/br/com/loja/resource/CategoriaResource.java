package br.com.loja.resource;

import br.com.loja.domains.CategoriaDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CategoriaResource {

    @ApiOperation(tags="Categorias", value="Listar Categorias")
    @GetMapping(value="/listar")
    List<CategoriaDTO> listarCategorias() throws Exception;

    @PostMapping(value="/incluir")
    void novaCategoria(@RequestBody CategoriaDTO categoria) throws Exception;

    @DeleteMapping(value="excluir")
    void excluirCategoria(Integer id) throws Exception;

}
