/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.EnfantSession;
import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.service.EnfantService;
import com.levinas.ecole.service.EnfantSessionService;
import com.levinas.ecole.service.InscriptionService;
import java.util.HashMap;
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
@RequestMapping(value = "/enfantSession")
public class EnfantSessionCtrl {

    @Autowired
    EnfantSessionService enfantSessionService;

    @Autowired
    EnfantService enfantService;

    @Autowired
    InscriptionService inscriptionService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public HashMap listAll(
            @RequestParam(value = "byInscription", required = false) Integer idInscription,
            @RequestParam(value = "byEnfant", required = false) Integer idEnfant) {

        if (idInscription != null) {
            Inscription inscription = inscriptionService.findByIdinscription(idInscription) ;
            return enfantSessionService.findByInscription(inscription);
        } else {
            if (idEnfant != null) {
                Enfant enfant = enfantService.FindById(idEnfant);
                return enfantSessionService.findByEnfant(enfant);
            } else {
                return enfantSessionService.findAll();
            }
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EnfantSession findById(@PathVariable int id) {
        EnfantSession enfantSession = enfantSessionService.findByIdenfantSession(id);
        return enfantSession;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public EnfantSession update(@RequestBody EnfantSession enfantSession) {
        enfantSessionService.update(enfantSession);
        return enfantSession;
    }

    @RequestMapping(method = RequestMethod.POST)
    public EnfantSession create(@RequestBody EnfantSession enfantSession) {
        enfantSessionService.save(enfantSession);
        return enfantSession;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        EnfantSession enfantSession = enfantSessionService.findByIdenfantSession(id);
        enfantSessionService.delete(enfantSession);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
