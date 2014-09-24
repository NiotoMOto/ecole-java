/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.AnneeScolaireEnfant;
import com.levinas.ecole.service.EnfantService;
import com.levinas.ecole.service.AnneeScolaireEnfantService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Administrateur
 */
@Controller
@RestController
@Configuration
@RequestMapping(value = "/anneeScolaireEnfant")
public class AnneeScolaireEnfantCtrl {

    @Autowired
    AnneeScolaireEnfantService anneeScolaireEnfantService;

    @Autowired
    EnfantService enfantService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<AnneeScolaireEnfant> listAll(
            @RequestParam(value = "byEnfant", required = false) Integer idEnfant
    ) {
        if (idEnfant != null) {
            Enfant enfant = enfantService.FindById(idEnfant);
            return anneeScolaireEnfantService.findByIdenfant(enfant);
        }
        return anneeScolaireEnfantService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AnneeScolaireEnfant findById(@PathVariable int id) {
        AnneeScolaireEnfant anneeScolaireEnfant = anneeScolaireEnfantService.findByIdanneeScolaireEnfant(id);
        return anneeScolaireEnfant;
    }

    @RequestMapping(method = RequestMethod.POST)
    public AnneeScolaireEnfant create(@RequestBody AnneeScolaireEnfant anneeScolaireEnfant) {
        anneeScolaireEnfantService.save(anneeScolaireEnfant);
        return anneeScolaireEnfant;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        AnneeScolaireEnfant anneeScolaireEnfant = anneeScolaireEnfantService.findByIdanneeScolaireEnfant(id);
        anneeScolaireEnfantService.delete(anneeScolaireEnfant);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
