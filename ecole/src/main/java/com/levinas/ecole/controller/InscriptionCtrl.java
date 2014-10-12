/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Activite;
import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.service.ActiviteService;
import com.levinas.ecole.service.InscriptionService;
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
@RequestMapping(value = "/inscription")
public class InscriptionCtrl {

    @Autowired
    InscriptionService inscriptionService;

    @Autowired
    ActiviteService activiteService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Inscription> listAll(
            @RequestParam(value = "byActivite", required = false) Integer idActivite
    ) 
    {
        if (idActivite != null) {
            Activite activite = activiteService.findByIdactivite(idActivite);
            return inscriptionService.findByActivite(activite);
        }

        return inscriptionService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Inscription findById(@PathVariable int id) {
        Inscription inscription = inscriptionService.findByIdinscription(id);
        return inscription;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Inscription update(@RequestBody Inscription inscription) {
        inscriptionService.update(inscription);
        return inscription;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Inscription create(@RequestBody Inscription inscription) {
        inscriptionService.save(inscription);
        return inscription;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Inscription inscription = inscriptionService.findByIdinscription(id);
        inscriptionService.delete(inscription);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
