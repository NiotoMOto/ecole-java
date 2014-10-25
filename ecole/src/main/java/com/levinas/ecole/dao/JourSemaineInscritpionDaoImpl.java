/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.model.JourSemaineInscritpion;
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
public class JourSemaineInscritpionDaoImpl implements JourSemaineInscritpionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(JourSemaineInscritpion jourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        session.save(jourSemaineInscritpion);
    }
    
    @Override
    public void update(JourSemaineInscritpion jourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        session.update(jourSemaineInscritpion);
    }

    @Override
    public void delete(JourSemaineInscritpion jourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(jourSemaineInscritpion);
    }

    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("Inscription.findAll");
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }
    
    @Override
    public HashMap findByInscription(Inscription inscription) {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.createQuery("SELECT jsi FROM JourSemaineInscritpion jsi WHERE jsi.inscriptionIdinscription = :inscription");
        query.setParameter("inscription", inscription);
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }


    @Override
    public JourSemaineInscritpion findByIdjourSemaineInscritpion(int idJourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("JourSemaineInscritpion.findByIdjourSemaineInscritpion");
        query.setParameter("idjourSemaineInscritpion", idJourSemaineInscritpion);
        return (JourSemaineInscritpion)query.uniqueResult();
    }

}
