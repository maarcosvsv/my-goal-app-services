package br.com.personal.metasprofissionais.dao;

import br.com.personal.metasprofissionais.entity.Setor;

import java.util.List;

public interface SetorDao {

    List<Setor> findAll();

    void insertSetor (Setor s);

    void updateSetor (Setor s);

    void deleteSetor(Setor s);




}
