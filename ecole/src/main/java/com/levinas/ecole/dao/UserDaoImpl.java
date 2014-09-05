/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.User;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Antone
 */
@Repository
@Configuration
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List listAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User ");
        List list = query.list();
        return list ;
    }

    @Override
    public void saveOrUpdate(User user) {
       Session session = sessionFactory.getCurrentSession();
       session.saveOrUpdate(user);
    }
    
    @Override
    public void delete(User user){
        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
    }

    @Override
    public List findByMail(String mail) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User as user where user.email=:mail");
        query.setParameter("mail", mail);
        return query.list();
    }
    
    @Override
    public User findByIdUser(int idUser) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.getNamedQuery("User.findByIdUser");
        query.setParameter("idUser", idUser);
        return (User)query.uniqueResult();
    }

    @Override
    public List findByUsername(String username) {
         Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("FROM User as user where user.username=:username");
        query.setParameter("username", username);
        return query.list();
    }

}
