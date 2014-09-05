/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.ResponsableEnfant;
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
public class ResponsableEnfantDaoImpl implements ResponsableEnfantDao{
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
    
}
