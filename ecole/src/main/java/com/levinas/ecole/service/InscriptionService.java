/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Activite;
import com.levinas.ecole.model.Inscription;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface InscriptionService {
    
    public void save(Inscription inscription);
    public void update(Inscription inscription);
    public List findAll();
    public List findByActivite(Activite activite);
    public void delete(Inscription inscription);
    public Inscription findByIdinscription (int idInscription);

}
