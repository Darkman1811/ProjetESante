package data;

import data.Pays;
import data.Ville;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Region.class)
public class Region_ { 

    public static volatile SingularAttribute<Region, Integer> id;
    public static volatile ListAttribute<Region, Ville> villes;
    public static volatile SingularAttribute<Region, Pays> pays;
    public static volatile SingularAttribute<Region, String> nom_region;

}