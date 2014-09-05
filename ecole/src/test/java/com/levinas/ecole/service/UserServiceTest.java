/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.UserDao;
import com.levinas.ecole.model.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Administrateur
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class UserServiceTest {
    
    @Autowired
    UserService userService;
    
    @Test
    public void MainTest(){
        User user = new User();
        user.setEmail("mailTest");
        user.setPassword("passwordTest");
        user.setUsername("usernameTest");
        
        userService.saveOrUpdate(user);
        Assert.assertNotNull(user.getIdUser());
        
        userService.delete(user);
        
        
        Assert.assertEquals(0,userService.findByMail("mailTest").size());
        
        
    }
    
}
