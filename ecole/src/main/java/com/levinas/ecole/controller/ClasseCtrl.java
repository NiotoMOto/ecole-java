/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Classe;
import com.levinas.ecole.service.ClasseService;
import java.util.HashMap;
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
@RequestMapping(value = "/classe")
public class ClasseCtrl {

    @Autowired
    ClasseService classeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public HashMap listAll() {
        return classeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Classe findById(@PathVariable int id) {
        Classe classe = classeService.findByIdclasse(id);
        return classe;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Classe update(@RequestBody Classe classe) {
        classeService.saveOrUpdate(classe);
        return classe;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Classe create(@RequestBody Classe classe) {
        classeService.saveOrUpdate(classe);
        return classe;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Classe classe = classeService.findByIdclasse(id);
        classeService.delete(classe);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
