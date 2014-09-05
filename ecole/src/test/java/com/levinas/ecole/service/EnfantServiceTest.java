/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.User;
import com.levinas.ecole.service.EnfantService;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-test.xml")
public class EnfantServiceTest {

    @Autowired
    EnfantService enfantService;

    @Autowired
    UserService userService;

    @Test
    @Transactional
    public void MainTst() {

        User user = new User();
        user.setEmail("mailTestUser");
        user.setUsername("UserNameTest");
        user.setPassword("passwordTest");
        userService.saveOrUpdate(user);

        Enfant enfant = new Enfant();
        enfant.setNom("EnfantTestNom");
        enfant.setPrenom("EnfantTestPrenom");
        enfant.setUserIdUser(user);
        enfantService.saveOrUpdate(enfant);

        enfant = (Enfant) enfantService.findByNom("EnfantTestNom").get(0);
        Assert.assertEquals("EnfantTestNom", enfant.getNom());

        enfantService.delete(enfant);
        userService.delete(user);

       /* Assert.assertEquals(0, userService.findByMail("mailTestUser").size());
        Assert.assertEquals(0, enfantService.findByNom("EnfantTestNom").size());*/

    }

}
