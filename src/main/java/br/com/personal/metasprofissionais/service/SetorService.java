package br.com.personal.metasprofissionais.service;

import br.com.personal.metasprofissionais.entity.Setor;

import java.util.List;

public interface SetorService {


    List<Setor> findAll();

    void insertSetor(Setor s);

    void updateSetor(Setor s);

    void deleteSetor(Setor s);




}
