/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.model.JourSemaineInscritpion;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface JourSemaineInscritpionDao {
    public void save(JourSemaineInscritpion jourSemaineInscritpion);
    public void update(JourSemaineInscritpion jourSemaineInscritpion);
    public HashMap findAll();
    public HashMap findByInscription(Inscription inscription);
    public void delete(JourSemaineInscritpion jourSemaineInscritpion);
    public JourSemaineInscritpion findByIdjourSemaineInscritpion (int idJourSemaineInscritpion);
}
