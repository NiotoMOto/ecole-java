/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.JourSemaineInscritpion;
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
public class JourSemaineInscritpionDaoImpl implements JourSemaineInscritpionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(JourSemaineInscritpion jourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        session.save(jourSemaineInscritpion);
    }

    @Override
    public void delete(JourSemaineInscritpion jourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(jourSemaineInscritpion);
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("JourSemaineInscritpion.findAll");
        return query.list();
    }


    @Override
    public JourSemaineInscritpion findByIdjourSemaineInscritpion(int idJourSemaineInscritpion) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("JourSemaineInscritpion.findByIdjourSemaineInscritpion");
        query.setParameter("idjourSemaineInscritpion", idJourSemaineInscritpion);
        return (JourSemaineInscritpion)query.uniqueResult();
    }

}
