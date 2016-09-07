package data;

import data.RV;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(Client.class)
public class Client_ { 

    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, String> prenom;
    public static volatile SingularAttribute<Client, String> phone;
    public static volatile SingularAttribute<Client, String> email;
    public static volatile SingularAttribute<Client, String> age;
    public static volatile SingularAttribute<Client, String> civilite;
    public static volatile ListAttribute<Client, RV> rv;
    public static volatile SingularAttribute<Client, String> nom;

}