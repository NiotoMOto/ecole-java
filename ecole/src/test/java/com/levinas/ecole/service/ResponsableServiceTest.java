/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.TypeResponsable;
import com.levinas.ecole.model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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
public class ResponsableServiceTest {

    @Autowired
    ResponsableService responsableService;

    @Autowired
    UserService userService;

    @Autowired
    EnfantService enfantService;
    
    @Autowired
    TypeResponsableService typeResponsableService;

      @Before
   public void setUp() {
    
   }
    
    @Test
    @Transactional
    public void mainTest() {
        try{
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
        
        

        Responsable responsable = new Responsable();
        responsable.setNom("nom Test");
        responsableService.saveOrUpdate(responsable);
        
        TypeResponsable typeResponsable = new TypeResponsable();
        typeResponsable.setLibelle("libelleTest");
        typeResponsableService.saveOrUpdate(typeResponsable);
        
        Assert.assertNotNull("Resonsable Null",responsable.getIdresponsable());
        
        responsableService.addEnfant(responsable, enfant, typeResponsable);
        
        
      
        responsableService.delete(responsable);
        enfantService.delete(enfant);
        userService.delete(user);
        typeResponsableService.delete(typeResponsable);
        }catch(Exception e){
            Assert.assertNull("Exception levé",e);
        }
    }

}
