/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.model.Etablissement;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface EtablissementService {

    public HashMap findAll();
    public Etablissement findByIdetablissement(int idEtablissement);
    public List findByLibelle(String libelle);
    public void saveOrUpdate(Etablissement etablissement);
    public void delete(Etablissement etablissement);

}
