/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Activite;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Inscription;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface InscriptionDao {
    public void save(Inscription inscription);
    public void update(Inscription inscription);
    public HashMap findAll();
    public HashMap findByActivite(Activite activite);
    public void delete(Inscription inscription);
    public Inscription findByIdinscription (int idInscription);
}

