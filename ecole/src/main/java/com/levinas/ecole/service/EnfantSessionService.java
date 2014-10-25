/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.EnfantSession;
import com.levinas.ecole.model.Inscription;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface EnfantSessionService {
    
    public void save(EnfantSession enfantSession);
    public void update(EnfantSession enfantSession);
    public HashMap findAll();
    public HashMap findByInscription(Inscription inscription);
    public HashMap findByEnfant(Enfant enfant);
    public void delete(EnfantSession enfantSession);
    public EnfantSession findByIdenfantSession (int idEnfantSession);

}

