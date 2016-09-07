package data;

import data.Client;
import data.Planning;
import data.Pratiquant;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-16T14:21:13")
@StaticMetamodel(RV.class)
public class RV_ { 

    public static volatile SingularAttribute<RV, Integer> id;
    public static volatile SingularAttribute<RV, String> etat;
    public static volatile SingularAttribute<RV, Date> heureFinRV;
    public static volatile SingularAttribute<RV, String> codeRV;
    public static volatile SingularAttribute<RV, Client> client;
    public static volatile SingularAttribute<RV, Pratiquant> pratiquant;
    public static volatile SingularAttribute<RV, Planning> planning;
    public static volatile SingularAttribute<RV, Date> dateRV;
    public static volatile SingularAttribute<RV, Date> heureDebutRV;

}