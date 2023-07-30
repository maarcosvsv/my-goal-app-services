package br.com.personal.metasprofissionais.dao;

import br.com.personal.metasprofissionais.dao.MetaDao;
import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.entity.Perfil;
import br.com.personal.metasprofissionais.mapper.MetaRowMapper;
import br.com.personal.metasprofissionais.mapper.PerfilRowMapper;
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
public class PerfilDaoImpl implements PerfilDao {

    NamedParameterJdbcTemplate template;

    public PerfilDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }


    @Override
    public List<Perfil> findAll() {
        return template.query("select * from perfil", new PerfilRowMapper());
    }

    @Override
    public void insertPerfil(Perfil p) {
        String sql = "insert into perfil(nome) values(:nome)";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("nome", p.getNome());

        template.update(sql, param, holder);
    }

    @Override
    public void updatePerfil(Perfil p) {
        String sql = "update perfil set nome=:nome where id=:id";

        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("id", p.getId())
                .addValue("nome", p.getNome());
        template.update(sql,param, holder);
    }


    @Override
    public void deletePerfil(Perfil p) {
        String sql = "delete from perfil where id=:id";


        Map<String,Object> map=new HashMap<String,Object>();
        map.put("id", p.getId());

        template.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });
    }

}
