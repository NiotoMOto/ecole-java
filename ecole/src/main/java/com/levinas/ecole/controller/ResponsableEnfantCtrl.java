/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.controller;

import com.levinas.ecole.model.ResponsableEnfant;
import com.levinas.ecole.service.ResponsableEnfantService;
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
@RequestMapping(value = "/responsableEnfant")
public class ResponsableEnfantCtrl {
    
    @Autowired
    ResponsableEnfantService responsableEnfantService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ResponsableEnfant> listAll() {
        return responsableEnfantService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponsableEnfant findById(@PathVariable int id) {
        ResponsableEnfant responsableEnfant = responsableEnfantService.findByIdresponsableEnfant(id);
        return responsableEnfant;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponsableEnfant create(@RequestBody ResponsableEnfant responsableEnfant) {
        responsableEnfantService.save(responsableEnfant);
        return responsableEnfant;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        ResponsableEnfant responsableEnfant = responsableEnfantService.findByIdresponsableEnfant(id);
        responsableEnfantService.delete(responsableEnfant);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    
    
}