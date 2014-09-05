/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.levinas.ecole.service;

import com.levinas.ecole.model.TypeResponsable;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public interface TypeResponsableService {

    public List findAll();

    public TypeResponsable findByIdtypeResponsable(int idTypeResponsable);

    public List findByLibelle(String libelle);

    public void saveOrUpdate(TypeResponsable typeResponsable);

    public void delete(TypeResponsable typeResponsable);

}
