/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.EnfantDao;
import com.levinas.ecole.model.Enfant;
import java.util.HashMap;
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
    
    @Override
    public List listAll(){
        return enfantDao.listAll();
    }
    
    @Override
    public HashMap listAll(int page, int rpp, String search){
        search = '%' + search + '%' ;
        return enfantDao.listAll(page, rpp, search);
    }
    
    @Transactional
    @Override
    public int saveOrUpdate(Enfant enfant){
        enfantDao.saveOrUpdate(enfant);
        return enfant.getIdEnfant() ;
    }
    
    
    
    @Override
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
