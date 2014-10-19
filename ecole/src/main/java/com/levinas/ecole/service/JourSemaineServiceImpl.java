/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.JourSemaineDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.JourSemaine;
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
public class JourSemaineServiceImpl implements JourSemaineService{

    @Autowired
    JourSemaineDao jourSemaineDao;

    @Override
    public void save(JourSemaine jourSemaine) {
        jourSemaineDao.save(jourSemaine);
    }
    
    @Override
    public void update(JourSemaine jourSemaine) {
        jourSemaineDao.update(jourSemaine);
    }

    @Override
    public HashMap findAll() {
        return jourSemaineDao.findAll();
    }
    
 
    @Override
    public void delete(JourSemaine jourSemaine) {
        jourSemaineDao.delete(jourSemaine);
    }

    @Override
    public JourSemaine findByIdjourSemaine(int idJourSemaine) {
        return jourSemaineDao.findByIdjourSemaine(idJourSemaine);
    }

    
}
