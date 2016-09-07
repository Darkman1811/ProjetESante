package data;

import data.Planning;
import data.Service;
import data.Ville;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Structure.class)
public class Structure_ { 

    public static volatile SingularAttribute<Structure, Integer> id;
    public static volatile SingularAttribute<Structure, Byte[]> logo;
    public static volatile ListAttribute<Structure, Service> services;
    public static volatile SingularAttribute<Structure, String> adresse;
    public static volatile SingularAttribute<Structure, String> email;
    public static volatile SingularAttribute<Structure, String> nom_structure;
    public static volatile SingularAttribute<Structure, Ville> ville;
    public static volatile SingularAttribute<Structure, String> longitude;
    public static volatile SingularAttribute<Structure, String> latitude;
    public static volatile SingularAttribute<Structure, String> siteWeb;
    public static volatile ListAttribute<Structure, Planning> plannings;
    public static volatile SingularAttribute<Structure, String> blog;
    public static volatile SingularAttribute<Structure, String> telephone;

}