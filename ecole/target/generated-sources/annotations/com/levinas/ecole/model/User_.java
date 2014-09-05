package com.levinas.ecole.model;

import com.levinas.ecole.model.Enfant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-09-05T16:36:45")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile ListAttribute<User, Enfant> enfantList;
    public static volatile SingularAttribute<User, Date> createTime;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> password;

}