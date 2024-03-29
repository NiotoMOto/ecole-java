/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.EnfantSession;
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
public class EnfantSessionDaoImpl implements EnfantSessionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(EnfantSession enfantSession) {
        Session session = sessionFactory.getCurrentSession();
        session.save(enfantSession);
    }
    
    @Override
    public void update(EnfantSession enfantSession) {
        Session session = sessionFactory.getCurrentSession();
        session.update(enfantSession);
    }

    @Override
    public void delete(EnfantSession enfantSession) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(enfantSession);
    }

    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("EnfantSession.findAll");
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
        Query query = session.createQuery("SELECT es FROM EnfantSession es WHERE es.idinscription = :inscription");
        query.setParameter("inscription", inscription);
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }
    
    @Override
    public HashMap findByEnfant(Enfant enfant) {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.createQuery("SELECT es FROM EnfantSession es WHERE es.idenfant = :enfant");
        query.setParameter("enfant", enfant);
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }


    @Override
    public EnfantSession findByIdenfantSession(int idEnfantSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("EnfantSession.findByIdenfantSession");
        query.setParameter("idenfantSession", idEnfantSession);
        return (EnfantSession)query.uniqueResult();
    }

}
