/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.ResponsableEnfant;

/**
 *
 * @author Administrateur
 */
public interface ResponsableEnfantDao {
    public void save(ResponsableEnfant responsableEnfant);
    public void delete(ResponsableEnfant responsableEnfant);
    
}
