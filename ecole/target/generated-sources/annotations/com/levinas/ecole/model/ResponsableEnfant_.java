package com.levinas.ecole.model;

import com.levinas.ecole.model.Enfant;
import com.levinas.ecole.model.Responsable;
import com.levinas.ecole.model.TypeResponsable;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T16:36:46")
@StaticMetamodel(ResponsableEnfant.class)
public class ResponsableEnfant_ { 

    public static volatile SingularAttribute<ResponsableEnfant, TypeResponsable> idtypeResponsable;
    public static volatile SingularAttribute<ResponsableEnfant, Enfant> idenfant;
    public static volatile SingularAttribute<ResponsableEnfant, Integer> idresponsableEnfant;
    public static volatile SingularAttribute<ResponsableEnfant, Responsable> idresponsable;

}