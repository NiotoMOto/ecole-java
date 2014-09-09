/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.controller;

import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.service.ResponsableService;
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
@RequestMapping(value = "/responsable")
public class ResponsableCtrl {
    
    
    @Autowired
    ResponsableService responsableService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Responsable> listAll() {
        return responsableService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Responsable findById(@PathVariable int id) {
        Responsable responsable = responsableService.findByIdresponsable(id);
        return responsable;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Responsable create(@RequestBody Responsable responsable) {
        responsableService.saveOrUpdate(responsable);
        return responsable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Responsable responsable = responsableService.findByIdresponsable(id);
        responsableService.delete(responsable);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    
}