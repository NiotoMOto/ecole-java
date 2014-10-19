/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Enfant;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Antone
 */
public interface EnfantService {
    public HashMap listAll();
    public HashMap listAll(int page, int rpp, String search);
    public Enfant FindById(int idEnfant);
    public List findByNom(String nom);
    public int saveOrUpdate(Enfant enfant);
    public void delete(Enfant enfant);
}
