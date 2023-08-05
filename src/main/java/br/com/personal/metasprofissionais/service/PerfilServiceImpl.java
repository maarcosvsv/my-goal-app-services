package br.com.personal.metasprofissionais.service;

import br.com.personal.metasprofissionais.dao.PerfilDao;
import br.com.personal.metasprofissionais.entity.Meta;
import br.com.personal.metasprofissionais.entity.Perfil;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServiceImpl implements PerfilService {

    @Resource
    PerfilDao perfilDao;

    public List<Perfil> findAll(){
        return perfilDao.findAll();

    };

    public void insertPerfil(Perfil perfil){
        perfilDao.insertPerfil(perfil);
    }

    public void updatePerfil(Perfil perfil){
        perfilDao.updatePerfil(perfil);
    }

    public void deletePerfil(Perfil perfil){
        perfilDao.deletePerfil(perfil);
    }


}
