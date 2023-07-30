package br.com.personal.metasprofissionais.dao;

import br.com.personal.metasprofissionais.entity.Meta;

import java.util.List;

public interface MetaDao {

    List<Meta> findAll();

    void insertMeta(Meta meta);

    void updateMeta(Meta meta);

    void executeUpdateMeta(Meta meta);

    void deleteMeta(Meta meta);

}
