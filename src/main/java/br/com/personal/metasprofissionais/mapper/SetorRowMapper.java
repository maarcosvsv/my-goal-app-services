package br.com.personal.metasprofissionais.mapper;

import br.com.personal.metasprofissionais.entity.Setor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SetorRowMapper implements RowMapper<Setor> {

    @Override
    public Setor mapRow(ResultSet rs, int arg1) throws SQLException {
        Setor s = new Setor();
        s.setId(rs.getLong("id"));
        s.setNome(rs.getString("nome"));

        return s;
    }
}
