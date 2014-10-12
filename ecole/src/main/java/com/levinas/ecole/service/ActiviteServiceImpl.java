/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.ActiviteDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Activite;
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
public class ActiviteServiceImpl implements ActiviteService{

    @Autowired
    ActiviteDao activiteDao;

    @Override
    public void save(Activite activite) {
        activiteDao.save(activite);
    }
    
    @Override
    public void update(Activite activite) {
        activiteDao.update(activite);
    }

    @Override
    public List findAll() {
        return activiteDao.findAll();
    }
    
 
    @Override
    public void delete(Activite activite) {
        activiteDao.delete(activite);
    }

    @Override
    public Activite findByIdactivite(int idActivite) {
        return activiteDao.findByIdactivite(idActivite);
    }

    
}
