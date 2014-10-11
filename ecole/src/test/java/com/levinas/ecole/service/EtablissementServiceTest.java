/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.model.Etablissement;
import org.junit.Assert;
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
public class EtablissementServiceTest {

    @Autowired
    EtablissementService etablissementService;

    @Test
    @Transactional
    public void MainTst() {
        Etablissement etablissement = new Etablissement();
        etablissement.setLibelle("levinas");
        etablissement.setAdresse("adresse");
        etablissement.setCodePostal("78799");
        etablissement.setVille("Conflans");
        etablissementService.saveOrUpdate(etablissement);
        
        Etablissement etablissement1 = (Etablissement)etablissementService.findByLibelle("levinas").get(0);
        Assert.assertEquals("levinas", etablissement1.getLibelle());
        Assert.assertEquals("adresse", etablissement1.getAdresse());
        Assert.assertEquals("78799", etablissement1.getCodePostal());
        Assert.assertEquals("Conflans", etablissement1.getVille());
        
        etablissementService.delete(etablissement1);
        
        
    }
}


