/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.TypeResponsableDao;
import com.levinas.ecole.model.TypeResponsable;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */
@Service
@Configuration
@Transactional
public class TypeResponsableServiceImpl implements TypeResponsableService{

    @Autowired
    TypeResponsableDao typeResponsableDao;
    
    @Override
    public HashMap findAll() {
        return typeResponsableDao.findAll();
    }

    @Override
    public TypeResponsable findByIdtypeResponsable(int idTypeResponsable) {
        return typeResponsableDao.findByIdtypeResponsable(idTypeResponsable);
    }

    @Override
    public List findByLibelle(String libelle) {
        return typeResponsableDao.findByLibelle(libelle);
    }

    @Override
    public void saveOrUpdate(TypeResponsable typeResponsable) {
        typeResponsableDao.saveOrUpdate(typeResponsable);
    }

    @Override
    public void delete(TypeResponsable typeResponsable) {
        typeResponsableDao.delete(typeResponsable);
    }
    
}
