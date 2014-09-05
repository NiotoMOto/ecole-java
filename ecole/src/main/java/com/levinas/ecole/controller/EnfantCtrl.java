/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.service.EnfantService;
import com.levinas.ecole.service.UserService;
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
 * @author Antone
 */
@Controller
@RestController
@Configuration
@RequestMapping(value = "/enfant")
public class EnfantCtrl {

    @Autowired
    private EnfantService enfantService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Enfant> getAll() {
        return enfantService.listAll();
    }
    
   @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Enfant findById(@PathVariable int id) {
        Enfant enfant = enfantService.FindById(id);
        return enfant;
    }
/*
    @RequestMapping(method = RequestMethod.POST)
    public Enfant create(@RequestBody HashMap<String,String> param) {

        User user = userService.findByIdtypeResponsable(Integer.parseInt(param.get("idUser")));
        Enfant enfant = new Enfant();
        enfant.setPrenom(param.get("prenom"));
        enfant.setPrenom(param.get("nom"));
        enfant.setUserIdUser(user);
        enfantService.saveOrUpdate(enfant);
        return enfant;
    }
    
    */
    
        @RequestMapping(method = RequestMethod.POST)
    public Enfant create(@RequestBody Enfant enfant) {
        enfantService.saveOrUpdate(enfant);
        return enfant;
    }
    
 @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Enfant enfant = enfantService.FindById(id);
        enfantService.delete(enfant);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    

}
