package br.com.personal.metasprofissionais.mapper;

import br.com.personal.metasprofissionais.entity.Meta;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MetaRowMapper implements RowMapper<Meta> {

    @Override
    public Meta mapRow(ResultSet rs, int arg1) throws SQLException {
        Meta meta = new Meta();
        meta.setId(rs.getLong("id"));
        meta.setTitulo(rs.getString("titulo"));
        meta.setDescricao(rs.getString("descricao"));
        meta.setPontos(rs.getInt("pontos"));
        meta.setDuracao(rs.getInt("duracao"));
        meta.setDataCriacao(rs.getTimestamp("dt_criacao").toLocalDateTime());

        return meta;
    }

}
