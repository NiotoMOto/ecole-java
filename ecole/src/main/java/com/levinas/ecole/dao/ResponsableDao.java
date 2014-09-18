/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Responsable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface ResponsableDao {
    public List findAll();
    public HashMap listAll(int page, int rpp, String search);
    public Responsable findByIdresponsable(int idResponsable);
    public List findByNom(String nom);
    public List findByPrenom(String prenom);
    public List findByVille(String ville);
    public List findByCodePostale(String codePostal);
    public void saveOrUpdate(Responsable responsable);
    public void delete(Responsable responsable);
    
}
