/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.EnfantSession;
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
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("EnfantSession.findAll");
        return query.list();
    }


    @Override
    public EnfantSession findByIdenfantSession(int idEnfantSession) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("EnfantSession.findByIdenfantSession");
        query.setParameter("idenfantSession", idEnfantSession);
        return (EnfantSession)query.uniqueResult();
    }

}
