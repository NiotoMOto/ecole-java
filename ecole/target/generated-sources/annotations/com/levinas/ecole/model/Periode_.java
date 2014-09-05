package com.levinas.ecole.model;

import com.levinas.ecole.model.Inscription;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T16:36:46")
@StaticMetamodel(Periode.class)
public class Periode_ { 

    public static volatile ListAttribute<Periode, Inscription> inscriptionList;
    public static volatile SingularAttribute<Periode, Date> fin;
    public static volatile SingularAttribute<Periode, Date> debut;
    public static volatile SingularAttribute<Periode, Integer> idperiode;

}