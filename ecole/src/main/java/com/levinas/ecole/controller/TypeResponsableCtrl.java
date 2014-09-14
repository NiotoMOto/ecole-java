/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.TypeResponsable;
import com.levinas.ecole.service.TypeResponsableService;
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
@RequestMapping(value = "/typeResponsable")
public class TypeResponsableCtrl {

    @Autowired
    TypeResponsableService typeResponsableService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<TypeResponsable> listAll() {
        return typeResponsableService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public TypeResponsable findById(@PathVariable int id) {
        TypeResponsable typeResponsable = typeResponsableService.findByIdtypeResponsable(id);
        return typeResponsable;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public TypeResponsable update(@RequestBody TypeResponsable typeResponsable) {
        typeResponsableService.saveOrUpdate(typeResponsable);
        return typeResponsable;
    }

    @RequestMapping(method = RequestMethod.POST)
    public TypeResponsable create(@RequestBody TypeResponsable typeResponsable) {
        typeResponsableService.saveOrUpdate(typeResponsable);
        return typeResponsable;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        TypeResponsable typeResponsable = typeResponsableService.findByIdtypeResponsable(id);
        typeResponsableService.delete(typeResponsable);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }

}
