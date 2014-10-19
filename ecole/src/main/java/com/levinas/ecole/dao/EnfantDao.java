/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Enfant;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Antone
 */
public interface EnfantDao {
    
    public HashMap listAll();
    public HashMap listAll(int page, int rpp, String search);
    public Enfant FindById(int idEnfant);
    public void saveOrUpdate(Enfant enfant);
    public List findByNom(String nom);
    public List findByPrenom(String prenom);
    public void delete(Enfant enfant);
    
}
