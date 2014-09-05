package com.levinas.ecole.model;

import com.levinas.ecole.model.PeriodeJours;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T12:19:25")
@StaticMetamodel(Jour.class)
public class Jour_ { 

    public static volatile SingularAttribute<Jour, Integer> idjour;
    public static volatile ListAttribute<Jour, PeriodeJours> periodeJoursList1;
    public static volatile SingularAttribute<Jour, String> jour;
    public static volatile ListAttribute<Jour, PeriodeJours> periodeJoursList;

}