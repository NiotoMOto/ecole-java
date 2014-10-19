/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.TypeResponsable;
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
public class TypeResponsableDaoImpl implements TypeResponsableDao{

     @Autowired
     SessionFactory sessionFactory;
    
    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("TypeResponsable.findAll");
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }

    @Override
    public TypeResponsable findByIdtypeResponsable(int idTypeResponsable) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("TypeResponsable.findByIdtypeResponsable");
        query.setParameter("idtypeResponsable", idTypeResponsable);
        return (TypeResponsable)query.uniqueResult();
    }

    @Override
    public List findByLibelle(String libelle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("TypeResponsable.findAll");
        query.setParameter("libelle", libelle);
        return query.list();
    }

    @Override
    public void saveOrUpdate(TypeResponsable typeResponsable) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(typeResponsable);
    }

    @Override
    public void delete(TypeResponsable typeResponsable) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(typeResponsable);
    }
    
}
