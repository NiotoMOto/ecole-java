package com.levinas.ecole.model;

import com.levinas.ecole.model.ResponsableEnfant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T12:19:25")
@StaticMetamodel(TypeResponsable.class)
public class TypeResponsable_ { 

    public static volatile SingularAttribute<TypeResponsable, Integer> idtypeResponsable;
    public static volatile SingularAttribute<TypeResponsable, String> libelle;
    public static volatile ListAttribute<TypeResponsable, ResponsableEnfant> responsableEnfantList;

}