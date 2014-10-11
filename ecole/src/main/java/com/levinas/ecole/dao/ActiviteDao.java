/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Activite;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface ActiviteDao {
    public void save(Activite activite);
    public List findAll();
    public void delete(Activite activite);
    public Activite findByIdactivite (int idActivite);
}