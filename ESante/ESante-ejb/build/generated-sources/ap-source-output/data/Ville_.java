package data;

import data.Region;
import data.Structure;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Ville.class)
public class Ville_ { 

    public static volatile SingularAttribute<Ville, Integer> id;
    public static volatile SingularAttribute<Ville, Region> region;
    public static volatile SingularAttribute<Ville, String> nom_ville;
    public static volatile ListAttribute<Ville, Structure> structures;

}