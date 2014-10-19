/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.ClasseDao;
import com.levinas.ecole.model.Classe;
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
public class ClasseServiceImpl implements ClasseService{

    @Autowired
    ClasseDao classeDao;
    
    @Override
    public HashMap findAll() {
        return classeDao.findAll();
    }

    @Override
    public Classe findByIdclasse(int idClasse) {
        return classeDao.findByIdclasse(idClasse);
    }

    @Override
    public List findByLibelle(String libelle) {
        return classeDao.findByLibelle(libelle);
    }

    @Override
    public void saveOrUpdate(Classe classe) {
        classeDao.saveOrUpdate(classe);
    }

    @Override
    public void delete(Classe classe) {
        classeDao.delete(classe);
    }
    
}