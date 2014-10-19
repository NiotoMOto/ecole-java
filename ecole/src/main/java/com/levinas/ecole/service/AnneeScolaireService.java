/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.AnneeScolaire;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface AnneeScolaireService {

    public HashMap findAll();
    public AnneeScolaire findByIdanneeScolaire(int idAnneeScolaire);
    public List findByLibelle(String libelle);
    public void saveOrUpdate(AnneeScolaire anneeScolaire);
    public void delete(AnneeScolaire anneeScolaire);

}
