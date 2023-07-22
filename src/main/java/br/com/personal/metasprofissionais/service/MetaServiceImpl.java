package br.com.personal.metasprofissionais.service;

import br.com.personal.metasprofissionais.dao.MetaDao;
import br.com.personal.metasprofissionais.entity.Meta;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MetaServiceImpl implements MetaService {

    @Resource
    MetaDao metaDao;

    public List<Meta> findAll(){
        return metaDao.findAll();

    };

    public void insertMeta(Meta meta){
        metaDao.insertMeta(meta);
    }

    public void updateMeta(Meta meta){
        metaDao.updateMeta(meta);
    }

    public void executeUpdateMeta(Meta meta){
        metaDao.executeUpdateMeta(meta);
    }

    public void deleteMeta(Meta meta){
        metaDao.deleteMeta(meta);
    }

}
