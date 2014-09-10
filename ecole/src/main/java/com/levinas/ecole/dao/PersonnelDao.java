/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Personnel;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Antone
 */
public interface PersonnelDao {
    
    public List listAll();
    public Personnel FindById(int idPersonnel);
    public void saveOrUpdate(Personnel personnel);
    public List findByNom(String nom);
    public List findByPrenom(String prenom);
    public void delete(Personnel personnel);
    
}
