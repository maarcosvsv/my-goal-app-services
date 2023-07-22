package br.com.personal.metasprofissionais.service;

import br.com.personal.metasprofissionais.entity.Meta;



import java.util.List;

public interface MetaService {

    List<Meta> findAll();

    void insertMeta(Meta emp);

    void updateMeta(Meta emp);

    void executeUpdateMeta(Meta emp);

    void deleteMeta(Meta emp);

}
