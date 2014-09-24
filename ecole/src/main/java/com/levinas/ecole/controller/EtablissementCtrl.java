/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Etablissement;
import com.levinas.ecole.service.EtablissementService;
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
@RequestMapping(value = "/etablissement")
public class EtablissementCtrl {

    @Autowired
    EtablissementService etablissementService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Etablissement> listAll() {
        return etablissementService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Etablissement findById(@PathVariable int id) {
        Etablissement etablissement = etablissementService.findByIdetablissement(id);
        return etablissement;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Etablissement update(@RequestBody Etablissement etablissement) {
        etablissementService.saveOrUpdate(etablissement);
        return etablissement;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Etablissement create(@RequestBody Etablissement etablissement) {
        etablissementService.saveOrUpdate(etablissement);
        return etablissement;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Etablissement etablissement = etablissementService.findByIdetablissement(id);
        etablissementService.delete(etablissement);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
