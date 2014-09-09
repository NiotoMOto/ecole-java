/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.EnfantDao;
import com.levinas.ecole.model.Enfant;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antone
 */
@Service
@Configuration
@Transactional
public class EnfantServiceImpl implements EnfantService{
    
    @Autowired
    private EnfantDao enfantDao ;
    
    public List listAll(){
        return enfantDao.listAll();
    }
    @Transactional
    public int saveOrUpdate(Enfant enfant){
        int id = -1 ;
        enfantDao.saveOrUpdate(enfant);
        return enfant.getIdEnfant() ;
    }
    
    
    
    public Enfant FindById(int idEnfant){
        return enfantDao.FindById(idEnfant);
    }

    @Override
    public List findByNom(String nom) {
        return enfantDao.findByNom(nom);
    }

    @Override
    public void delete(Enfant enfant) {
        enfantDao.delete(enfant);
    }
    
    
}