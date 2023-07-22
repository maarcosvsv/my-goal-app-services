package br.com.personal.metasprofissionais.dao;

import br.com.personal.metasprofissionais.dao.MetaDao;
import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.mapper.MetaRowMapper;
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
public class MetaDaoImpl implements MetaDao {


    public MetaDaoImpl(NamedParameterJdbcTemplate template) {
            this.template = template;
        }
        NamedParameterJdbcTemplate template;

        @Override
        public List<Meta> findAll() {
            return template.query("select * from meta", new MetaRowMapper());
        }

        @Override
        public void insertMeta(Meta meta) {
            final String sql = "insert into meta(titulo , descricao, pontos, duracao) values(:titulo,:descricao,:pontos, :duracao)";

            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("titulo", meta.getTitulo())
                    .addValue("descricao", meta.getDescricao())
                    .addValue("pontos", meta.getPontos())
                    .addValue("duracao", meta.getDuracao());

            template.update(sql, param, holder);

        }

        @Override
        public void updateMeta(Meta meta) {
            final String sql = "update meta set titulo=:titulo, descricao=:descricao, pontos=:pontos, duracao=:duracao where id=:id";

            KeyHolder holder = new GeneratedKeyHolder();
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("id", meta.getId())
                    .addValue("titulo", meta.getTitulo())
                    .addValue("descricao", meta.getDescricao())
                    .addValue("pontos", meta.getPontos())
                    .addValue("duracao", meta.getDuracao());
            template.update(sql,param, holder);

        }

        @Override
        public void executeUpdateMeta(Meta meta) {
            final String sql = "update meta set titulo=:titulo, descricao=:descricao, pontos=:pontos, duracao=:duracao where id=:id";


            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id", meta.getId());
            map.put("titulo", meta.getTitulo());
            map.put("descricao", meta.getDescricao());
            map.put("pontos", meta.getPontos());
            map.put("duracao", meta.getDuracao());

            template.execute(sql,map,new PreparedStatementCallback<Object>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps)
                        throws SQLException, DataAccessException {
                    return ps.executeUpdate();
                }
            });


        }

        @Override
        public void deleteMeta(Meta meta) {
            final String sql = "delete from meta where id=:id";


            Map<String,Object> map=new HashMap<String,Object>();
            map.put("id", meta.getId());

            template.execute(sql,map,new PreparedStatementCallback<Object>() {
                @Override
                public Object doInPreparedStatement(PreparedStatement ps)
                        throws SQLException, DataAccessException {
                    return ps.executeUpdate();
                }
            });


        }

    }
