/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Activite;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface ActiviteService {
    
    public void save(Activite activite);
    public void update(Activite activite);
    public HashMap findAll();
    public void delete(Activite activite);
    public Activite findByIdactivite (int idActivite);

}

