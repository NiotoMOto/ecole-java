/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.ResponsableEnfant;
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
public class ResponsableEnfantDaoImpl implements ResponsableEnfantDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(ResponsableEnfant responsableEnfant) {
        Session session = sessionFactory.getCurrentSession();
        session.save(responsableEnfant);
    }

    @Override
    public void delete(ResponsableEnfant responsableEnfant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(responsableEnfant);
    }

    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("ResponsableEnfant.findAll");
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }

    @Override
    public HashMap findByIdenfant(Enfant enfant) {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.createQuery("SELECT r FROM ResponsableEnfant r WHERE r.idenfant = :idenfant");
        query.setParameter("idenfant", enfant);
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }

    @Override
    public List<ResponsableEnfant> findByIdresponsable(Responsable responsable) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("ResponsableEnfant.findByIdresponsable");
        return query.list();
    }

    @Override
    public ResponsableEnfant findByIdresponsableEnfant(int idResponsableEnfant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("ResponsableEnfant.findByIdresponsableEnfant");
        query.setParameter("idresponsableEnfant", idResponsableEnfant);
        return (ResponsableEnfant)query.uniqueResult();
    }

}
