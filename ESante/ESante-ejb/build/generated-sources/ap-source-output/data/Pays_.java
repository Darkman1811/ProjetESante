package data;

import data.Region;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Pays.class)
public class Pays_ { 

    public static volatile SingularAttribute<Pays, Integer> id;
    public static volatile SingularAttribute<Pays, Float> taux_de_convertion;
    public static volatile SingularAttribute<Pays, String> monaie;
    public static volatile SingularAttribute<Pays, String> nom_pays;
    public static volatile SingularAttribute<Pays, String> indicatif_telephonique;
    public static volatile ListAttribute<Pays, Region> regions;

}