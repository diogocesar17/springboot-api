package br.com.loja.dao.impl;

import br.com.loja.config.CreateDataSourceForJdbcTemplate;
import br.com.loja.dao.ProdutoDaoService;
import br.com.loja.domains.ProdutoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class ProdutoDaoServiceImpl implements ProdutoDaoService {

    @Override
    public void excluirProduto(Integer id) throws Exception {
        JdbcTemplate getJdbcTemplate = new JdbcTemplate();
        getJdbcTemplate.setDataSource((CreateDataSourceForJdbcTemplate.getDataSource()));
        StringBuilder query = new StringBuilder();

        query.append("delete from PRODUTOS where id = ?");
        getJdbcTemplate.update(query.toString(), id);
    }

    @Override
    public void novoProduto(@RequestBody ProdutoDTO produto) throws Exception {
        JdbcTemplate getJdbcTemplate = new JdbcTemplate();
        getJdbcTemplate.setDataSource(CreateDataSourceForJdbcTemplate.getDataSource());
        StringBuilder query = new StringBuilder();

        query.append("insert into PRODUTOS (ID, NOME, DESCRICAO, VALOR, QUANTIDADE, ID_CATEGORIA) VALUES (?, ?, ?, ?, ?, ?)");
        getJdbcTemplate.update(query.toString(),
                null,
                produto.getNome(),
                produto.getDescricao(),
                produto.getValor(),
                produto.getQuantidade(),
                produto.getIdCategoria());
    }

    @Override
    public List<ProdutoDTO> listarProdutos() throws Exception {
        return buscarProdutos();
    }

    private List<ProdutoDTO> buscarProdutos() throws Exception {

        JdbcTemplate getJdbcTemplate = new JdbcTemplate();
        getJdbcTemplate.setDataSource(CreateDataSourceForJdbcTemplate.getDataSource());
        StringBuilder query = new StringBuilder();

        query.append("select * from PRODUTOS");

        return getJdbcTemplate.query(query.toString(), new ProdutoDaoServiceImpl.ProdutoRowMapper());
    }

    public final class ProdutoRowMapper implements RowMapper {
        public ProdutoDTO mapRow(ResultSet rs, int rowNum) {
            ProdutoDTO dto = new ProdutoDTO();

            try {
                dto.setId(rs.getLong("ID"));
                dto.setNome(rs.getString("NOME"));
                dto.setDescricao(rs.getString("DESCRICAO"));
                dto.setValor(rs.getBigDecimal("VALOR"));
                dto.setQuantidade(rs.getInt("QUANTIDADE"));
                dto.setIdCategoria(rs.getLong("ID_CATEGORIA"));
            } catch (SQLException ex) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar os produtos");
            }
            return dto;
        }
    }
}
