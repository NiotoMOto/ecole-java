/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
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
public class EnfantDaoImpl implements EnfantDao{
    
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public List listAll(){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Enfant.findAll");
        return query.list();
    }
    
    @Override
     public HashMap listAll(int page, int rpp, String search){
        Integer iRpp = rpp ;
        HashMap result = new HashMap();
        
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Enfant e WHERE e.nom like :search OR e.prenom like :search");
        query.setParameter("search", search);
        double nbResult = query.list().size();
        
        query.setFirstResult((page - 1) * rpp);
        query.setMaxResults(rpp);
        List listItems = query.list();
        
        result.put("items", listItems);
        result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result ;
    }
    
    @Override
    public Enfant FindById(int idEnfant){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Enfant.findByIdEnfant");
        query.setParameter("idEnfant", idEnfant);
        return (Enfant)query.uniqueResult();
       
    }

    @Override
    public void saveOrUpdate(Enfant enfant) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(enfant);
    }

    @Override
    public List findByNom(String nom) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Enfant.findByNom");
        query.setParameter("nom", nom);
        return query.list();
    }

    @Override
    public List findByPrenom(String prenom) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Enfant enfant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(enfant);
    }
}
