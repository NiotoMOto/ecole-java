package com.levinas.ecole.model;

import com.levinas.ecole.model.AnneeScolaireEnfant;
import com.levinas.ecole.model.EnfantSession;
import com.levinas.ecole.model.ResponsableEnfant;
import com.levinas.ecole.model.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T16:36:45")
@StaticMetamodel(Enfant.class)
public class Enfant_ { 

    public static volatile SingularAttribute<Enfant, String> prenom;
    public static volatile ListAttribute<Enfant, EnfantSession> enfantSessionList;
    public static volatile SingularAttribute<Enfant, Integer> idEnfant;
    public static volatile SingularAttribute<Enfant, User> userIdUser;
    public static volatile ListAttribute<Enfant, ResponsableEnfant> responsableEnfantList;
    public static volatile ListAttribute<Enfant, AnneeScolaireEnfant> anneeScolaireEnfantList;
    public static volatile SingularAttribute<Enfant, String> nom;

}