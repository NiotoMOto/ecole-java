/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Activite;
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
public class ActiviteDaoImpl implements ActiviteDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Activite activite) {
        Session session = sessionFactory.getCurrentSession();
        session.save(activite);
    }
    
    @Override
    public void update(Activite activite) {
        Session session = sessionFactory.getCurrentSession();
        session.update(activite);
    }

    @Override
    public void delete(Activite activite) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(activite);
    }

    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("Activite.findAll");
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        
        return result;
    }


    @Override
    public Activite findByIdactivite(int idActivite) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Activite.findByIdactivite");
        query.setParameter("idactivite", idActivite);
        return (Activite)query.uniqueResult();
    }

}
