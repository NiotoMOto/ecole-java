/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.AnneeScolaire;
import java.util.HashMap;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Administrateur
 */
@Repository
@Configuration
public class AnneeScolaireDaoImpl implements AnneeScolaireDao{

     @Autowired
     SessionFactory sessionFactory;
    
    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("AnneeScolaire.findAll");
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        
        return result;
    }

    @Override
    public AnneeScolaire findByIdanneeScolaire(int idAnneeScolaire) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("AnneeScolaire.findByIdanneeScolaire");
        query.setParameter("idanneeScolaire", idAnneeScolaire);
        return (AnneeScolaire)query.uniqueResult();
    }

    @Override
    public List findByLibelle(String libelle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM AnneeScolaire e WHERE e.libelle = :libelle");
        query.setParameter("libelle", libelle);
        return query.list();
    }

    @Override
    public void saveOrUpdate(AnneeScolaire anneeScolaire) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(anneeScolaire);
    }

    @Override
    public void delete(AnneeScolaire anneeScolaire) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(anneeScolaire);
    }
    
}
