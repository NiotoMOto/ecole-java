/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.AnneeScolaireEnfant;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface AnneeScolaireEnfantService {
    
    public void save(AnneeScolaireEnfant anneeScolaireEnfant);
    public List findAll();
    public void delete(AnneeScolaireEnfant anneeScolaireEnfant);
    public AnneeScolaireEnfant findByIdanneeScolaireEnfant (int idAnneeScolaireEnfant);
    public List<AnneeScolaireEnfant> findByIdenfant (Enfant enfant);
    public List<AnneeScolaireEnfant> findByIdresponsable (Responsable responsable);
    
}
