package br.com.loja.service.impl;

import br.com.loja.dao.CategoriaDaoService;
import br.com.loja.domains.CategoriaDTO;
import br.com.loja.service.CategoriaService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    CategoriaDaoService dao;

    @Override
    public List<CategoriaDTO> listarCategorias() throws Exception {
        return this.dao.listarCategorias();
    }

    @Override
    public void novaCategoria(@RequestBody CategoriaDTO categoria) throws Exception {
        if("".equals(categoria.getNome())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Campo 'NOME' não pode estar vazio.");
        }

        this.dao.novaCategoria(categoria);
    }

    @Override
    public void excluirCategoria(Integer id) throws Exception {
        this.dao.excluirCategoria(id);
    }

}
