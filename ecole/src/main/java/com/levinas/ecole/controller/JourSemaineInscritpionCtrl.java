/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.model.JourSemaineInscritpion;
import com.levinas.ecole.service.InscriptionService;
import com.levinas.ecole.service.JourSemaineInscritpionService;
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
@RequestMapping(value = "/jourSemaineInscritpion")
public class JourSemaineInscritpionCtrl {

    @Autowired
    JourSemaineInscritpionService jourSemaineInscritpionService;

    @Autowired
    InscriptionService inscriptionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<JourSemaineInscritpion> listAll(
            @RequestParam(value = "byInscription", required = false) Integer idInscription
    ) {

        if (idInscription != null) {
            Inscription inscription = inscriptionService.findByIdinscription(idInscription);
            return jourSemaineInscritpionService.findByInscription(inscription);
        }
        return jourSemaineInscritpionService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public JourSemaineInscritpion findById(@PathVariable int id) {
        JourSemaineInscritpion jourSemaineInscritpion = jourSemaineInscritpionService.findByIdjourSemaineInscritpion(id);
        return jourSemaineInscritpion;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public JourSemaineInscritpion update(@RequestBody JourSemaineInscritpion jourSemaineInscritpion) {
        jourSemaineInscritpionService.update(jourSemaineInscritpion);
        return jourSemaineInscritpion;
    }

    @RequestMapping(method = RequestMethod.POST)
    public JourSemaineInscritpion create(@RequestBody JourSemaineInscritpion jourSemaineInscritpion) {
        jourSemaineInscritpionService.save(jourSemaineInscritpion);
        return jourSemaineInscritpion;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        JourSemaineInscritpion jourSemaineInscritpion = jourSemaineInscritpionService.findByIdjourSemaineInscritpion(id);
        jourSemaineInscritpionService.delete(jourSemaineInscritpion);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
