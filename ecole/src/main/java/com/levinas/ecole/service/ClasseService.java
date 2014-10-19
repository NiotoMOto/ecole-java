/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Classe;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface ClasseService {

    public HashMap findAll();
    public Classe findByIdclasse(int idClasse);
    public List findByLibelle(String libelle);
    public void saveOrUpdate(Classe classe);
    public void delete(Classe classe);

}
