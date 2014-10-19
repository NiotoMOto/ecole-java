/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.service;

import com.levinas.ecole.dao.PeriodeDao;
import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.Periode;
import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Administrateur
 */
@Service
@Configuration
@Transactional
public class PeriodeServiceImpl implements PeriodeService{

    @Autowired
    PeriodeDao periodeDao;

    @Override
    public void save(Periode periode) {
        periodeDao.save(periode);
    }
    
    @Override
    public void update(Periode periode) {
        periodeDao.update(periode);
    }


    @Override
    public HashMap findAll() {
        return periodeDao.findAll();
    }
    
 
    @Override
    public void delete(Periode periode) {
        periodeDao.delete(periode);
    }

    @Override
    public Periode findByIdperiode(int idPeriode) {
        return periodeDao.findByIdperiode(idPeriode);
    }

    
}
