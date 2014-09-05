package com.levinas.ecole.model;

import com.levinas.ecole.model.Activite;
import com.levinas.ecole.model.EnfantSession;
import com.levinas.ecole.model.Periode;
import com.levinas.ecole.model.PeriodeJours;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T12:19:25")
@StaticMetamodel(Inscription.class)
public class Inscription_ { 

    public static volatile ListAttribute<Inscription, EnfantSession> enfantSessionList;
    public static volatile SingularAttribute<Inscription, Integer> idinscription;
    public static volatile SingularAttribute<Inscription, Float> prix;
    public static volatile SingularAttribute<Inscription, Periode> periodeIdperiode;
    public static volatile SingularAttribute<Inscription, PeriodeJours> periodeJoursIdperiodeJours;
    public static volatile SingularAttribute<Inscription, Activite> idactivite;

}