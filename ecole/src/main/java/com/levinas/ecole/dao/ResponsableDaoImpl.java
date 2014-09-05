/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Responsable;
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
public class ResponsableDaoImpl implements ResponsableDao{

    @Autowired
    SessionFactory sessionFactory;
    
    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Responsable.findAll");
        return query.list();
    }

    @Override
    public Responsable findByIdresponsable(int idResponsable) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Responsable.findByIdresponsable");
        query.setParameter("idresponsable", idResponsable);
        return (Responsable) query.uniqueResult();
    }

    @Override
    public List findByNom(String nom) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Responsable.findByNom");
        query.setParameter("nom", nom);
        return query.list();
    }

    @Override
    public List findByPrenom(String prenom) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Responsable.findByPrenom");
        query.setParameter("prenom", prenom);
        return query.list();
    }

    @Override
    public List findByVille(String ville) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Responsable.findByVille");
        query.setParameter("ville", ville);
        return query.list();
    }

    @Override
    public List findByCodePostale(String codePostal) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Responsable.findByCodePostale");
        query.setParameter("codePostale", codePostal);
        return query.list();
    }

    @Override
    public void saveOrUpdate(Responsable responsable) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(responsable);
    }

    @Override
    public void delete(Responsable responsable) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(responsable);
    }
    
    

    
    
}
