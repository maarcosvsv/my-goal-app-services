package br.com.personal.metasprofissionais.service;

import br.com.personal.metasprofissionais.entity.Perfil;

import java.util.List;

public interface PerfilService {


    List<Perfil> findAll();

    void insertPerfil(Perfil p);

    void updatePerfil(Perfil p);

    void deletePerfil(Perfil p);




}
