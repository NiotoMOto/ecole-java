/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Activite;
import com.levinas.ecole.service.ActiviteService;
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
@RequestMapping(value = "/activite")
public class ActiviteCtrl {

    @Autowired
    ActiviteService activiteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Activite> listAll() {
        return activiteService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Activite findById(@PathVariable int id) {
        Activite activite = activiteService.findByIdactivite(id);
        return activite;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Activite update(@RequestBody Activite activite) {
        activiteService.update(activite);
        return activite;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Activite create(@RequestBody Activite activite) {
        activiteService.save(activite);
        return activite;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Activite activite = activiteService.findByIdactivite(id);
        activiteService.delete(activite);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
