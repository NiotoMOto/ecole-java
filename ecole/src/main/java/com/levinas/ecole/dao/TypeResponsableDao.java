/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.dao;

import com.levinas.ecole.model.TypeResponsable;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface TypeResponsableDao {

    public HashMap findAll();

    public TypeResponsable findByIdtypeResponsable(int idTypeResponsable);

    public List findByLibelle(String libelle);

    public void saveOrUpdate(TypeResponsable typeResponsable);
    
    public void delete(TypeResponsable typeResponsable);
}
