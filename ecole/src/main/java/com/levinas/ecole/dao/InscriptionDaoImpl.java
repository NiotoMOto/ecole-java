/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Activite;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Inscription;
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
public class InscriptionDaoImpl implements InscriptionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Inscription inscription) {
        Session session = sessionFactory.getCurrentSession();
        session.save(inscription);
    }
    
    @Override
    public void update(Inscription inscription) {
        Session session = sessionFactory.getCurrentSession();
        session.update(inscription);
    }

    @Override
    public void delete(Inscription inscription) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(inscription);
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
    public HashMap findByActivite(Activite activite) {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.createQuery("SELECT i FROM Inscription i WHERE i.idactivite = :activite");
        query.setParameter("activite", activite);
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }


    @Override
    public Inscription findByIdinscription(int idInscription) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Inscription.findByIdinscription");
        query.setParameter("idinscription", idInscription);
        return (Inscription)query.uniqueResult();
    }

}
