/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Personnel;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Antone
 */
public interface PersonnelService {
    public List listAll();
    public HashMap listAll(int page, int rpp, String search);
    public Personnel FindById(int idPersonnel);
    public List findByNom(String nom);
    public int saveOrUpdate(Personnel personnel);
    public void delete(Personnel personnel);
}
