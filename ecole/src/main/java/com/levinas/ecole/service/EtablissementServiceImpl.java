/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.EtablissementDao;
import com.levinas.ecole.model.Etablissement;
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
public class EtablissementServiceImpl implements EtablissementService{

    @Autowired
    EtablissementDao etablissementDao;
    
    @Override
    public HashMap findAll() {
        return etablissementDao.findAll();
    }

    @Override
    public Etablissement findByIdetablissement(int idEtablissement) {
        return etablissementDao.findByIdetablissement(idEtablissement);
    }

    @Override
    public List findByLibelle(String libelle) {
        return etablissementDao.findByLibelle(libelle);
    }

    @Override
    public void saveOrUpdate(Etablissement etablissement) {
        etablissementDao.saveOrUpdate(etablissement);
    }

    @Override
    public void delete(Etablissement etablissement) {
        etablissementDao.delete(etablissement);
    }
    
}