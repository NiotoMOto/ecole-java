/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Etablissement;
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
public class EtablissementDaoImpl implements EtablissementDao{

     @Autowired
     SessionFactory sessionFactory;
    
    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Etablissement.findAll");
        return query.list();
    }

    @Override
    public Etablissement findByIdetablissement(int idEtablissement) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Etablissement.findByIdetablissement");
        query.setParameter("idetablissement", idEtablissement);
        return (Etablissement)query.uniqueResult();
    }

    @Override
    public List findByLibelle(String libelle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Etablissement e WHERE e.libelle = :libelle");
        query.setParameter("libelle", libelle);
        return query.list();
    }

    @Override
    public void saveOrUpdate(Etablissement etablissement) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(etablissement);
    }

    @Override
    public void delete(Etablissement etablissement) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(etablissement);
    }
    
}
