/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.JourSemaine;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface JourSemaineDao {
    public void save(JourSemaine jourSemaine);
    public void update(JourSemaine jourSemaine);
    public HashMap findAll();
    public void delete(JourSemaine jourSemaine);
    public JourSemaine findByIdjourSemaine (int idJourSemaine);
}

