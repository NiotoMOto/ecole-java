/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.dao.ResponsableDao;
import com.levinas.ecole.dao.ResponsableEnfantDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.ResponsableEnfant;
import com.levinas.ecole.model.TypeResponsable;
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
public class ResponsableServiceImpl implements ResponsableService {

    @Autowired
    ResponsableDao responsableDao;

    @Autowired
    ResponsableEnfantDao responsableEnfantDao;
    

    @Override
    public List findAll() {
        return responsableDao.findAll();
    }

    @Override
    public Responsable findByIdresponsable(int idResponsable) {
        return responsableDao.findByIdresponsable(idResponsable);
    }

    @Override
    public List findByNom(String nom) {
        return responsableDao.findByNom(nom);
    }

    @Override
    public List findByPrenom(String prenom) {
        return responsableDao.findByPrenom(prenom);
    }

    @Override
    public List findByVille(String ville) {
        return responsableDao.findByVille(ville);
    }

    @Override
    public List findByCodePostale(String codePostal) {
        return responsableDao.findByCodePostale(codePostal);
    }

    @Override
    public void saveOrUpdate(Responsable responsable) {
        responsableDao.saveOrUpdate(responsable);
    }

    @Override
    public void delete(Responsable responsable) {
        responsableDao.delete(responsable);
    }

    @Override
    public void addEnfant(Responsable responsable, Enfant enfant, TypeResponsable typeResponsable) {
        ResponsableEnfant responsableEnfant = new ResponsableEnfant();
        responsableEnfant.setIdenfant(enfant);
        responsableEnfant.setIdresponsable(responsable);
        responsableEnfant.setIdtypeResponsable(typeResponsable);
        responsableEnfantDao.save(responsableEnfant);
    }

}
