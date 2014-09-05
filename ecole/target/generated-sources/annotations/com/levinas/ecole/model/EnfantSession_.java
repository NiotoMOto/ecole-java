package com.levinas.ecole.model;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Inscription;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T12:19:25")
@StaticMetamodel(EnfantSession.class)
public class EnfantSession_ { 

    public static volatile SingularAttribute<EnfantSession, Integer> idenfantSession;
    public static volatile SingularAttribute<EnfantSession, Inscription> idinscription;
    public static volatile SingularAttribute<EnfantSession, Enfant> idenfant;

}