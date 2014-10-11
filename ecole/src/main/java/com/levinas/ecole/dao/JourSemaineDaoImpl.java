/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.JourSemaine;
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
public class JourSemaineDaoImpl implements JourSemaineDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(JourSemaine jourSemaine) {
        Session session = sessionFactory.getCurrentSession();
        session.save(jourSemaine);
    }

    @Override
    public void delete(JourSemaine jourSemaine) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(jourSemaine);
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("JourSemaine.findAll");
        return query.list();
    }


    @Override
    public JourSemaine findByIdjourSemaine(int idJourSemaine) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("JourSemaine.findByIdjourSemaine");
        query.setParameter("idjourSemaine", idJourSemaine);
        return (JourSemaine)query.uniqueResult();
    }

}