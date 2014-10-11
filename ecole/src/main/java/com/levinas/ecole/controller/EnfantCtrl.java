/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.service.EnfantService;
import com.levinas.ecole.service.UserService;
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
import org.springframework.web.bind.annotation.RequestParam;
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
    public HashMap getAll(
            @RequestParam(value="page", required= false, defaultValue = "0") Integer page, 
            @RequestParam(value = "rpp", required = false, defaultValue = "") Integer rpp,
            @RequestParam(value = "search", required = false, defaultValue = "") String search) {
            if(page == null || rpp == null ||search == null){
                return enfantService.listAll(1, 1, "");
            }else{
                return enfantService.listAll(page, rpp, search);
            }
        
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
    
    @RequestMapping(method = RequestMethod.PUT)
    public Enfant update(@RequestBody Enfant enfant) {
        enfantService.saveOrUpdate(enfant);
        return enfant;
    }
    
     @RequestMapping(value="/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> update2(@PathVariable int id, @RequestBody Enfant enfant) {
        Enfant enfantId = enfantService.FindById(id);
        if(enfantId == null){
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.NOT_FOUND);
        }else{
            enfantService.saveOrUpdate(enfant);
            return new ResponseEntity<>(Boolean.TRUE, HttpStatus.OK);
        }
        
    }
    
 @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Enfant enfant = enfantService.FindById(id);
        enfantService.delete(enfant);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    

}
