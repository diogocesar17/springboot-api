package br.com.loja.service;

import br.com.loja.domains.ProdutoDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProdutoService {

    List<ProdutoDTO> listarProdutos() throws Exception;

    void novoProduto(@RequestBody ProdutoDTO produto) throws Exception;

    void excluirProduto(Integer id) throws Exception;
}
