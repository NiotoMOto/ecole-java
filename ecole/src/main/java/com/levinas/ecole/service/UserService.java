/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.User;
import java.util.List;

/**
 *
 * @author Antone
 */
public interface UserService {
    
    public List listAll();
    public int saveOrUpdate(User user);
    public void delete(User user);
    public List findByMail(String mail);
    public User findByUsername(String username);
    public User findByIdtypeResponsable(int idUser);
    
}


