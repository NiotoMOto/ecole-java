/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.EnfantSessionDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.EnfantSession;
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
public class EnfantSessionServiceImpl implements EnfantSessionService{

    @Autowired
    EnfantSessionDao enfantSessionDao;

    @Override
    public void save(EnfantSession enfantSession) {
        enfantSessionDao.save(enfantSession);
    }
    
    @Override
    public void update(EnfantSession enfantSession) {
        enfantSessionDao.update(enfantSession);
    }

    @Override
    public HashMap findAll() {
        return enfantSessionDao.findAll();
    }
    
    @Override
    public HashMap findByInscription(Inscription inscription){
        return enfantSessionDao.findByInscription(inscription);
    }
    
    @Override
    public HashMap findByEnfant(Enfant enfant){
        return enfantSessionDao.findByEnfant(enfant);
    }
    
    @Override
    public void delete(EnfantSession enfantSession) {
        enfantSessionDao.delete(enfantSession);
    }

    @Override
    public EnfantSession findByIdenfantSession(int idEnfantSession) {
        return enfantSessionDao.findByIdenfantSession(idEnfantSession);
    }

    
}
