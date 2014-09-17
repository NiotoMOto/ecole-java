/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.ResponsableEnfantDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.ResponsableEnfant;
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
public class ResponsableEnfantServiceImpl implements ResponsableEnfantService{

    @Autowired
    ResponsableEnfantDao responsableEnfantDao;

    @Override
    public void save(ResponsableEnfant responsableEnfant) {
        responsableEnfantDao.save(responsableEnfant);
    }

    @Override
    public List findAll() {
        return responsableEnfantDao.findAll();
    }
    
 
    @Override
    public void delete(ResponsableEnfant responsableEnfant) {
        responsableEnfantDao.delete(responsableEnfant);
    }

    @Override
    public ResponsableEnfant findByIdresponsableEnfant(int idResponsableEnfant) {
        return responsableEnfantDao.findByIdresponsableEnfant(idResponsableEnfant);
    }

    @Override
    public List<ResponsableEnfant> findByIdenfant(Enfant enfant) {
        return responsableEnfantDao.findByIdenfant(enfant);
    }

    @Override
    public List<ResponsableEnfant> findByIdresponsable(Responsable responsable) {
        return responsableEnfantDao.findByIdresponsable(responsable);
    }
    
    
    
}
