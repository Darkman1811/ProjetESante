package data;

import data.Planning;
import data.RV;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Pratiquant.class)
public class Pratiquant_ { 

    public static volatile SingularAttribute<Pratiquant, String> prenom;
    public static volatile SingularAttribute<Pratiquant, String> specialite;
    public static volatile SingularAttribute<Pratiquant, Planning> planning;
    public static volatile SingularAttribute<Pratiquant, String> age;
    public static volatile SingularAttribute<Pratiquant, String> civilite;
    public static volatile ListAttribute<Pratiquant, RV> rv;
    public static volatile SingularAttribute<Pratiquant, String> nom;
    public static volatile SingularAttribute<Pratiquant, String> titre;

}