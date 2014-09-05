package com.levinas.ecole.model;

import com.levinas.ecole.model.ResponsableEnfant;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T16:36:46")
@StaticMetamodel(Responsable.class)
public class Responsable_ { 

    public static volatile SingularAttribute<Responsable, String> prenom;
    public static volatile SingularAttribute<Responsable, String> adresse;
    public static volatile SingularAttribute<Responsable, String> codePostale;
    public static volatile SingularAttribute<Responsable, String> ville;
    public static volatile ListAttribute<Responsable, ResponsableEnfant> responsableEnfantList;
    public static volatile SingularAttribute<Responsable, Integer> idresponsable;
    public static volatile SingularAttribute<Responsable, String> nom;

}