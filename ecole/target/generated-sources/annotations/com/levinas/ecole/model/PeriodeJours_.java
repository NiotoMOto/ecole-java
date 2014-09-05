package com.levinas.ecole.model;

import com.levinas.ecole.model.Inscription;
import com.levinas.ecole.model.Jour;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T16:36:45")
@StaticMetamodel(PeriodeJours.class)
public class PeriodeJours_ { 

    public static volatile ListAttribute<PeriodeJours, Inscription> inscriptionList;
    public static volatile SingularAttribute<PeriodeJours, Jour> jourDebut;
    public static volatile SingularAttribute<PeriodeJours, Jour> jourFin;
    public static volatile SingularAttribute<PeriodeJours, Integer> idperiodeJours;

}