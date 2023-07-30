package br.com.personal.metasprofissionais.mapper;

import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.entity.Perfil;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PerfilRowMapper implements RowMapper<Perfil> {

    @Override
    public Perfil mapRow(ResultSet rs, int arg1) throws SQLException {
        Perfil p = new Perfil();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));

        return p;
    }
}
