/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.EnfantSession;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface EnfantSessionService {
    
    public void save(EnfantSession enfantSession);
    public List findAll();
    public void delete(EnfantSession enfantSession);
    public EnfantSession findByIdenfantSession (int idEnfantSession);

}
