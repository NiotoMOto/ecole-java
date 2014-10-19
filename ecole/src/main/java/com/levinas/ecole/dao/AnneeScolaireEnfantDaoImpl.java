/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.AnneeScolaireEnfant;
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
 * @author Administrateur
 */
@Repository
@Configuration
public class AnneeScolaireEnfantDaoImpl implements AnneeScolaireEnfantDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void save(AnneeScolaireEnfant anneeScolaireEnfant) {
        Session session = sessionFactory.getCurrentSession();
        session.save(anneeScolaireEnfant);
    }

    @Override
    public void delete(AnneeScolaireEnfant anneeScolaireEnfant) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(anneeScolaireEnfant);
    }

    @Override
    public HashMap findAll() {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.getNamedQuery("AnneeScolaireEnfant.findAll");
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }

    @Override
    public HashMap findByIdenfant(Enfant enfant) {
        Session session = sessionFactory.getCurrentSession();
        HashMap result = new HashMap();
        Query query = session.createQuery("SELECT r FROM AnneeScolaireEnfant r WHERE r.idenfant = :idenfant");
        query.setParameter("idenfant", enfant);
        double nbResult = query.list().size();
        List listItems = query.list();
        
        result.put("items", listItems);
        //result.put("page_count", Math.ceil(nbResult/iRpp.doubleValue()));
        result.put("total_items",nbResult);
        return result;
    }

    @Override
    public List<AnneeScolaireEnfant> findByIdresponsable(Responsable responsable) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("AnneeScolaireEnfant.findByIdresponsable");
        return query.list();
    }

    @Override
    public AnneeScolaireEnfant findByIdanneeScolaireEnfant(int idAnneeScolaireEnfant) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("AnneeScolaireEnfant.findByIdanneeScolaireEnfant");
        query.setParameter("idanneeScolaireEnfant", idAnneeScolaireEnfant);
        return (AnneeScolaireEnfant)query.uniqueResult();
    }

}
