package br.com.loja.resource.impl;


import br.com.loja.domains.ProdutoDTO;
import br.com.loja.resource.ProdutosResource;
import br.com.loja.service.ProdutoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags="Produtos")
@RequestMapping("/produtos")
public class ProdutosResourceImpl implements ProdutosResource {

    @Autowired
    private ProdutoService service;

    @Override
    public List<ProdutoDTO> listarProdutos() throws Exception {
        return this.service.listarProdutos();
    }

    @Override
    public void novoProduto(@RequestBody ProdutoDTO produto) throws  Exception {
        this.service.novoProduto(produto);
    }

    @Override
    public void excluirProduto(Integer id) throws Exception {
        this.service.excluirProduto(id);
    }
}
