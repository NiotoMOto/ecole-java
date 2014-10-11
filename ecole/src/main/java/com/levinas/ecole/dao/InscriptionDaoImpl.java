/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Inscription;
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
public class InscriptionDaoImpl implements InscriptionDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Inscription inscription) {
        Session session = sessionFactory.getCurrentSession();
        session.save(inscription);
    }

    @Override
    public void delete(Inscription inscription) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(inscription);
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Inscription.findAll");
        return query.list();
    }


    @Override
    public Inscription findByIdinscription(int idInscription) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Inscription.findByIdinscription");
        query.setParameter("idinscription", idInscription);
        return (Inscription)query.uniqueResult();
    }

}
