/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Periode;
import com.levinas.ecole.service.PeriodeService;
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
@RequestMapping(value = "/periode")
public class PeriodeCtrl {

    @Autowired
    PeriodeService periodeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public HashMap listAll() {
        return periodeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Periode findById(@PathVariable int id) {
        Periode periode = periodeService.findByIdperiode(id);
        return periode;
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public Periode update(@RequestBody Periode periode) {
        periodeService.update(periode);
        return periode;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Periode create(@RequestBody Periode periode) {
        periodeService.save(periode);
        return periode;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Periode periode = periodeService.findByIdperiode(id);
        periodeService.delete(periode);
        return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
    }

}
