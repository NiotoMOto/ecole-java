/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.dao;

import com.levinas.ecole.model.Etablissement;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface EtablissementDao {

    public List findAll();

    public Etablissement findByIdetablissement(int idEtablissement);

    public List findByLibelle(String libelle);

    public void saveOrUpdate(Etablissement etablissement);
    
    public void delete(Etablissement etablissement);
}
