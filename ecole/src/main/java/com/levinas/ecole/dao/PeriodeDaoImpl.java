/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Periode;
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
public class PeriodeDaoImpl implements PeriodeDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(Periode periode) {
        Session session = sessionFactory.getCurrentSession();
        session.save(periode);
    }

    @Override
    public void delete(Periode periode) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(periode);
    }

    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Periode.findAll");
        return query.list();
    }


    @Override
    public Periode findByIdperiode(int idPeriode) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Periode.findByIdperiode");
        query.setParameter("idperiode", idPeriode);
        return (Periode)query.uniqueResult();
    }

}
