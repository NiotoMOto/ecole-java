/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Classe;
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
public class ClasseDaoImpl implements ClasseDao{

     @Autowired
     SessionFactory sessionFactory;
    
    @Override
    public List findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Classe.findAll");
        return query.list();
    }

    @Override
    public Classe findByIdclasse(int idClasse) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("Classe.findByIdclasse");
        query.setParameter("idclasse", idClasse);
        return (Classe)query.uniqueResult();
    }

    @Override
    public List findByLibelle(String libelle) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("SELECT e FROM Classe e WHERE e.libelle = :libelle");
        query.setParameter("libelle", libelle);
        return query.list();
    }

    @Override
    public void saveOrUpdate(Classe classe) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(classe);
    }

    @Override
    public void delete(Classe classe) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(classe);
    }
    
}


