/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.ResponsableEnfant;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface ResponsableEnfantService {
    
    public void save(ResponsableEnfant responsableEnfant);
    public List findAll();
    public void delete(ResponsableEnfant responsableEnfant);
    public ResponsableEnfant findByIdresponsableEnfant (int idResponsableEnfant);
    public List<ResponsableEnfant> findByIdenfant (Enfant enfant);
    public List<ResponsableEnfant> findByIdresponsable (Responsable responsable);
    
}
