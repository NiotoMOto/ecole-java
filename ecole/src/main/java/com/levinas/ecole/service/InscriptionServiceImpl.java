/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.InscriptionDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Inscription;
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
public class InscriptionServiceImpl implements InscriptionService{

    @Autowired
    InscriptionDao inscriptionDao;

    @Override
    public void save(Inscription inscription) {
        inscriptionDao.save(inscription);
    }

    @Override
    public List findAll() {
        return inscriptionDao.findAll();
    }
    
 
    @Override
    public void delete(Inscription inscription) {
        inscriptionDao.delete(inscription);
    }

    @Override
    public Inscription findByIdinscription(int idInscription) {
        return inscriptionDao.findByIdinscription(idInscription);
    }

    
}
