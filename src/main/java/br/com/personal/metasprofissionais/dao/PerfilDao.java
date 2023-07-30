package br.com.personal.metasprofissionais.dao;

import br.com.personal.metasprofissionais.entity.Perfil;
import java.util.List;

public interface PerfilDao {

    List<Perfil> findAll();

    void insertPerfil (Perfil p);

    void updatePerfil (Perfil p);

    void deletePerfil(Perfil p);




}
