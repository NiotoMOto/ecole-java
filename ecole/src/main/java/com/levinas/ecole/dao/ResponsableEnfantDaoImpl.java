/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.ResponsableEnfant;
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
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("ResponsableEnfant.findAll");
        return query.list();
    }

    @Override
    public List<ResponsableEnfant> findByIdenfant(Enfant enfant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("ResponsableEnfant.findByIdenfant");
        return query.list();
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
        return (ResponsableEnfant)query.uniqueResult();
    }

}
