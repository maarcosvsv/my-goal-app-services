package br.com.personal.metasprofissionais.mapper;

import br.com.personal.metasprofissionais.entity.Meta;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

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

        LocalDateTime dataAtual = LocalDateTime.now();
        Duration diferenca = Duration.between(meta.getDataCriacao(), dataAtual);
        Long diasRestantes = diferenca.toDays();

        if(diasRestantes.compareTo(meta.getDuracao().longValue()) >= 0 ){
            meta.setDiasRestantes(-1L);
        } else {
            meta.setDiasRestantes(diasRestantes);
        }


        return meta;
    }

}
