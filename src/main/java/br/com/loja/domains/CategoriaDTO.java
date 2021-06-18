package br.com.loja.domains;

import lombok.Data;

import java.io.Serializable;

@Data
public class CategoriaDTO implements Serializable {

    private static final long serializable = 1L;

    private Long id;
    private String nome;
    private String descricao;

}
