/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.controller;

import com.levinas.ecole.model.Personnel;
import com.levinas.ecole.service.PersonnelService;
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
@RequestMapping(value = "/personnel")
public class PersonnelCtrl {

    @Autowired
    private PersonnelService personnelService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public HashMap getAll(
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
            @RequestParam(value = "rpp", required = false, defaultValue = "") Integer rpp,
            @RequestParam(value = "search", required = false, defaultValue = "") String search) {
        if (page == null || rpp == null || search == null) {
            return personnelService.listAll(1, 1, "");
        } else {
            return personnelService.listAll(page, rpp, search);
        }
    }

    
   @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public Personnel findById(@PathVariable int id) {
        Personnel personnel = personnelService.FindById(id);
        return personnel;
    }

    
        @RequestMapping(method = RequestMethod.PUT)
    public Personnel update(@RequestBody Personnel personnel) {
        personnelService.saveOrUpdate(personnel);
        return personnel;
    }
    
        @RequestMapping(method = RequestMethod.POST)
    public Personnel create(@RequestBody Personnel personnel) {
        personnelService.saveOrUpdate(personnel);
        return personnel;
    }
    
 @RequestMapping(value="/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        Personnel personnel = personnelService.FindById(id);
        personnelService.delete(personnel);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
    

}
