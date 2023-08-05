package br.com.personal.metasprofissionais.dao;

import br.com.personal.metasprofissionais.entity.Setor;
import br.com.personal.metasprofissionais.mapper.PerfilRowMapper;
import br.com.personal.metasprofissionais.mapper.SetorRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SetorDaoImpl implements SetorDao {

    NamedParameterJdbcTemplate template;

    public SetorDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    @Override
    public List<Setor> findAll() {
        return template.query("select * from setor", new SetorRowMapper());
    }

    @Override
    public void insertSetor(Setor s) {
        String sql = "insert into setor(nome) values(:nome)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("nome", s.getNome());

        template.update(sql, param, holder);
    }

    @Override
    public void updateSetor(Setor s) {
        String sql = "update setor set nome=:nome where id=:id";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", s.getId())
                .addValue("nome", s.getNome());
        template.update(sql,param, holder);
    }


    @Override
    public void deleteSetor(Setor s) {
        String sql = "delete from setor where id=:id";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", s.getId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

}
