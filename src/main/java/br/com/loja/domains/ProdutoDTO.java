package br.com.loja.domains;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ProdutoDTO implements Serializable {

    private static final long serializable = 1L;

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
    private int quantidade;
    private Long idCategoria;

}
