package data;

import data.Planning;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(JoursBloques.class)
public class JoursBloques_ { 

    public static volatile SingularAttribute<JoursBloques, Integer> id;
    public static volatile SingularAttribute<JoursBloques, Planning> planning;
    public static volatile SingularAttribute<JoursBloques, Date> debut_debut_bloque;
    public static volatile SingularAttribute<JoursBloques, Date> date_fin_bloque;
    public static volatile SingularAttribute<JoursBloques, String> raison;

}