package br.com.loja.resource;

import br.com.loja.domains.ProdutoDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ProdutosResource {

    @ApiOperation(tags="Produtos", value="Listar Produtos")
    @GetMapping(value="/listar")
    List<ProdutoDTO> listarProdutos() throws Exception;

    @PostMapping("/incluirProduto")
    void novoProduto(@RequestBody ProdutoDTO produto) throws Exception;

    @DeleteMapping("/excluir")
    void excluirProduto(Integer id) throws Exception;
}
