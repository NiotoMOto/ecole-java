/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.JourSemaineInscritpionDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.JourSemaineInscritpion;
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
public class JourSemaineInscritpionServiceImpl implements JourSemaineInscritpionService{

    @Autowired
    JourSemaineInscritpionDao jourSemaineInscritpionDao;

    @Override
    public void save(JourSemaineInscritpion jourSemaineInscritpion) {
        jourSemaineInscritpionDao.save(jourSemaineInscritpion);
    }
    
    @Override
    public void update(JourSemaineInscritpion jourSemaineInscritpion) {
        jourSemaineInscritpionDao.update(jourSemaineInscritpion);
    }

    @Override
    public List findAll() {
        return jourSemaineInscritpionDao.findAll();
    }
    @Override
    public List findByInscription(Inscription inscription){
        return jourSemaineInscritpionDao.findByInscription(inscription);
    }
    
 
    @Override
    public void delete(JourSemaineInscritpion jourSemaineInscritpion) {
        jourSemaineInscritpionDao.delete(jourSemaineInscritpion);
    }

    @Override
    public JourSemaineInscritpion findByIdjourSemaineInscritpion(int idJourSemaineInscritpion) {
        return jourSemaineInscritpionDao.findByIdjourSemaineInscritpion(idJourSemaineInscritpion);
    }

    
}
