/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.dao.UserDao;
import com.levinas.ecole.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Antone
 */
@Service
@Configuration
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List listAll() {
        return userDao.listAll();
    }

    @Override
    public int saveOrUpdate(User user) {
        int id = -1;
        userDao.saveOrUpdate(user);
        return id;
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
    
    @Override
    public User findByIdUser(int idUser) {
        return userDao.findByIdUser(idUser);
    }

    @Override
    public List findByMail(String mail) {
        return userDao.findByMail(mail);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public User findByIdtypeResponsable(int idUser) {
        return userDao.findByIdUser(idUser);
    }

}
