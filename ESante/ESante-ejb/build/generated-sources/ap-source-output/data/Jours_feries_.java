package data;

import data.Planning;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Jours_feries.class)
public class Jours_feries_ { 

    public static volatile SingularAttribute<Jours_feries, Integer> id;
    public static volatile SingularAttribute<Jours_feries, Planning> planning;
    public static volatile SingularAttribute<Jours_feries, Date> date_bloque;
    public static volatile SingularAttribute<Jours_feries, Integer> annee;
    public static volatile SingularAttribute<Jours_feries, String> fete;

}