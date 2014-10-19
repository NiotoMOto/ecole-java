/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.AnneeScolaireEnfantDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.AnneeScolaireEnfant;
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
public class AnneeScolaireEnfantServiceImpl implements AnneeScolaireEnfantService{

    @Autowired
    AnneeScolaireEnfantDao anneeScolaireEnfantDao;

    @Override
    public void save(AnneeScolaireEnfant anneeScolaireEnfant) {
        anneeScolaireEnfantDao.save(anneeScolaireEnfant);
    }

    @Override
    public HashMap findAll() {
        return anneeScolaireEnfantDao.findAll();
    }
    
 
    @Override
    public void delete(AnneeScolaireEnfant anneeScolaireEnfant) {
        anneeScolaireEnfantDao.delete(anneeScolaireEnfant);
    }

    @Override
    public AnneeScolaireEnfant findByIdanneeScolaireEnfant(int idAnneeScolaireEnfant) {
        return anneeScolaireEnfantDao.findByIdanneeScolaireEnfant(idAnneeScolaireEnfant);
    }

    @Override
    public HashMap findByIdenfant(Enfant enfant) {
        return anneeScolaireEnfantDao.findByIdenfant(enfant);
    }

    @Override
    public List<AnneeScolaireEnfant> findByIdresponsable(Responsable responsable) {
        return anneeScolaireEnfantDao.findByIdresponsable(responsable);
    }
    
    
    
}
