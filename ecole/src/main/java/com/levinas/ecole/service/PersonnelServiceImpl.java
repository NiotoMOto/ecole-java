/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.PersonnelDao;
import com.levinas.ecole.model.Personnel;
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
public class PersonnelServiceImpl implements PersonnelService{
    
    @Autowired
    private PersonnelDao personnelDao ;
    
    public List listAll(){
        return personnelDao.listAll();
    }
    @Transactional
    @Override
    public int saveOrUpdate(Personnel personnel){
        int id = -1 ;
        personnelDao.saveOrUpdate(personnel);
        return personnel.getIdpersonnel();
    }
    
    
    
    @Override
    public Personnel FindById(int idPersonnel){
        return personnelDao.FindById(idPersonnel);
    }

    @Override
    public List findByNom(String nom) {
        return personnelDao.findByNom(nom);
    }

    @Override
    public void delete(Personnel personnel) {
        personnelDao.delete(personnel);
    }
    
    
}
