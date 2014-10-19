/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.controller;

import com.levinas.ecole.model.User;
import com.levinas.ecole.service.UserService;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Administrateur
 */
public class UserCtrl {
        @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public HashMap listAll() {
        return userService.listAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable int id) {
        User user = userService.findByIdUser(id);
        return user;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public User update(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }

    @RequestMapping(method = RequestMethod.POST)
    public User create(@RequestBody User user) {
        userService.saveOrUpdate(user);
        return user;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        User user = userService.findByIdUser(id);
        userService.delete(user);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
