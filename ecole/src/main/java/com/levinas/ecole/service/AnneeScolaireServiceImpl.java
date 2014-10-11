/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.AnneeScolaireDao;
import com.levinas.ecole.model.AnneeScolaire;
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
public class AnneeScolaireServiceImpl implements AnneeScolaireService{

    @Autowired
    AnneeScolaireDao anneeScolaireDao;
    
    @Override
    public List findAll() {
        return anneeScolaireDao.findAll();
    }

    @Override
    public AnneeScolaire findByIdanneeScolaire(int idAnneeScolaire) {
        return anneeScolaireDao.findByIdanneeScolaire(idAnneeScolaire);
    }

    @Override
    public List findByLibelle(String libelle) {
        return anneeScolaireDao.findByLibelle(libelle);
    }

    @Override
    public void saveOrUpdate(AnneeScolaire anneeScolaire) {
        anneeScolaireDao.saveOrUpdate(anneeScolaire);
    }

    @Override
    public void delete(AnneeScolaire anneeScolaire) {
        anneeScolaireDao.delete(anneeScolaire);
    }
    
}