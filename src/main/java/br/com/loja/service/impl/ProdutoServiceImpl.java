package br.com.loja.service.impl;

import br.com.loja.dao.ProdutoDaoService;
import br.com.loja.domains.ProdutoDTO;
import br.com.loja.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoDaoService dao;

    @Override
    public List<ProdutoDTO> listarProdutos() throws Exception {
        return this.dao.listarProdutos();
    }

    @Override
    public void novoProduto(@RequestBody ProdutoDTO produto) throws Exception {

        if("".equals(produto.getNome())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Campo 'NOME' não pode estar vazio.");
        }

        if("".equals(produto.getValor())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Campo 'VALOR' não pode estar vazio.");
        }

        if("".equals(produto.getQuantidade())) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED, "Campo 'QUANTIDADE' não pode estar vazio.");
        }

        this.dao.novoProduto(produto);
    }

    @Override
    public void excluirProduto(Integer id) throws Exception {
        this.dao.excluirProduto(id);
    }
}
