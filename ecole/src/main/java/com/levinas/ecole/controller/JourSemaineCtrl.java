/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.JourSemaine;
import com.levinas.ecole.service.JourSemaineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrateur
 */
@Controller
@RestController
@Configuration
@RequestMapping(value = "/jourSemaine")
public class JourSemaineCtrl {

    @Autowired
    JourSemaineService jourSemaineService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<JourSemaine> listAll() {
        return jourSemaineService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JourSemaine findById(@PathVariable int id) {
        JourSemaine jourSemaine = jourSemaineService.findByIdjourSemaine(id);
        return jourSemaine;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public JourSemaine update(@RequestBody JourSemaine jourSemaine) {
        jourSemaineService.update(jourSemaine);
        return jourSemaine;
    }

    @RequestMapping(method = RequestMethod.POST)
    public JourSemaine create(@RequestBody JourSemaine jourSemaine) {
        jourSemaineService.save(jourSemaine);
        return jourSemaine;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        JourSemaine jourSemaine = jourSemaineService.findByIdjourSemaine(id);
        jourSemaineService.delete(jourSemaine);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
