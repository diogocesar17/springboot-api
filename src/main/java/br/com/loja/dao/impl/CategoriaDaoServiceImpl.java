package br.com.loja.dao.impl;

import br.com.loja.config.CreateDataSourceForJdbcTemplate;
import br.com.loja.dao.CategoriaDaoService;
import br.com.loja.domains.CategoriaDTO;
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
public class CategoriaDaoServiceImpl implements CategoriaDaoService {

    @Override
    public void excluirCategoria(Integer id) throws Exception {
        JdbcTemplate getJdbcTemplate = new JdbcTemplate();
        getJdbcTemplate.setDataSource((CreateDataSourceForJdbcTemplate.getDataSource()));
        StringBuilder query = new StringBuilder();

        query.append("delete from CATEGORIA where id = ?");
        getJdbcTemplate.update(query.toString(), id);
    }

    @Override
    public void novaCategoria(@RequestBody CategoriaDTO categoria) throws Exception {
        JdbcTemplate getJdbcTemplate = new JdbcTemplate();
        getJdbcTemplate.setDataSource(CreateDataSourceForJdbcTemplate.getDataSource());
        StringBuilder query = new StringBuilder();

        query.append("insert into CATEGORIA(ID, NOME, DESCRICAO) values (?, ?, ?)");

        getJdbcTemplate.update(query.toString(),
                null,
                categoria.getNome(),
                categoria.getDescricao());
    }

    @Override
    public List<CategoriaDTO> listarCategorias() throws Exception {
        return buscarCategorias();
    }

    private List<CategoriaDTO> buscarCategorias() throws Exception {
        JdbcTemplate getJdbcTemplate = new JdbcTemplate();
        getJdbcTemplate.setDataSource(CreateDataSourceForJdbcTemplate.getDataSource());
        StringBuilder query = new StringBuilder();

        query.append("select * from CATEGORIA");

        return getJdbcTemplate.query(query.toString(), new CategoriaDaoServiceImpl.CategoriaRowMapper());
    }

    public final class CategoriaRowMapper implements RowMapper {
        public CategoriaDTO mapRow(ResultSet rs, int rowNum) {
            CategoriaDTO dto = new CategoriaDTO();

            try {
                dto.setId(rs.getLong("ID"));
                dto.setNome((rs.getString("NOME")));
                dto.setDescricao((rs.getString("DESCRICAO")));
            } catch (SQLException ex) {
                throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Erro ao buscar as categorias");
            }
            return dto;
        }
    }

}
