/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.AnneeScolaire;
import com.levinas.ecole.service.AnneeScolaireService;
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
@RequestMapping(value = "/anneeScolaire")
public class AnneeScolaireCtrl {

    @Autowired
    AnneeScolaireService anneeScolaireService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AnneeScolaire> listAll() {
        return anneeScolaireService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AnneeScolaire findById(@PathVariable int id) {
        AnneeScolaire anneeScolaire = anneeScolaireService.findByIdanneeScolaire(id);
        return anneeScolaire;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public AnneeScolaire update(@RequestBody AnneeScolaire anneeScolaire) {
        anneeScolaireService.saveOrUpdate(anneeScolaire);
        return anneeScolaire;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AnneeScolaire create(@RequestBody AnneeScolaire anneeScolaire) {
        anneeScolaireService.saveOrUpdate(anneeScolaire);
        return anneeScolaire;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        AnneeScolaire anneeScolaire = anneeScolaireService.findByIdanneeScolaire(id);
        anneeScolaireService.delete(anneeScolaire);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
