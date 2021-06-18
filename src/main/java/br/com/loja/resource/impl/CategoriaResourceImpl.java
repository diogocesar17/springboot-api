package br.com.loja.resource.impl;

import br.com.loja.domains.CategoriaDTO;
import br.com.loja.resource.CategoriaResource;
import br.com.loja.service.CategoriaService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="Categorias")
@RequestMapping("/categorias")
public class CategoriaResourceImpl implements CategoriaResource {

    @Autowired
    private CategoriaService service;

    @Override
    public List<CategoriaDTO> listarCategorias() throws Exception {
        return this.service.listarCategorias();
    }

    @Override
    public void novaCategoria(@RequestBody CategoriaDTO categoria) throws Exception {
        this.service.novaCategoria(categoria);
    }

    @Override
    public void excluirCategoria(Integer id) throws Exception {
        this.service.excluirCategoria(id);
    }

}
