/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Personnel;
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
 * @author Antone
 */
@Repository
@Configuration
public class PersonnelDaoImpl implements PersonnelDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public List listAll(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Personnel.findAll");
        return query.list();
    }
    
    public HashMap listAll(int page, int rpp, String search){
               Integer iRpp = rpp ;
        HashMap result = new HashMap();
        
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Personnel.search");
        query.setParameter("search", search);
        double nbResult = query.list().size();
        
        query.setFirstResult((page - 1) * rpp);
        query.setMaxResults(rpp);
        List listItems = query.list();
        
        result.put("items", listItems);
        result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        
        return result;
    }
    
    public Personnel FindById(int idpersonnel){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Personnel.findByIdpersonnel");
        query.setParameter("idpersonnel", idpersonnel);
        return (Personnel)query.uniqueResult();
       
    }

    @Override
    public void saveOrUpdate(Personnel personnel) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(personnel);
    }

    @Override
    public List findByNom(String nom) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Personnel.findByNom");
        query.setParameter("nom", nom);
        return query.list();
    }

    @Override
    public List findByPrenom(String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Personnel personnel) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(personnel);
    }
}
