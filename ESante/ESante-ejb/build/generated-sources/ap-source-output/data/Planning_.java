package data;

import data.JoursBloques;
import data.Pratiquant;
import data.RV;
import data.Structure;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Planning.class)
public class Planning_ { 

    public static volatile SingularAttribute<Planning, Integer> id;
    public static volatile SingularAttribute<Planning, String> jours_de_semaine;
    public static volatile SingularAttribute<Planning, Structure> structure;
    public static volatile ListAttribute<Planning, Pratiquant> pratiquant;
    public static volatile SingularAttribute<Planning, Date> heure_fermeture;
    public static volatile ListAttribute<Planning, RV> rv;
    public static volatile ListAttribute<Planning, JoursBloques> joursBloques;
    public static volatile SingularAttribute<Planning, Date> heure_ouverture;

}