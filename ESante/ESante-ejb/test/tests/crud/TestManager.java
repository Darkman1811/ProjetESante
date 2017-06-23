/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests.crud;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import metier.ManagerRemote;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author darkman
 */
public class TestManager {
    private static EJBContainer ejbContainer;
    private static Context context;
    
    public TestManager() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ejbContainer=EJBContainer.createEJBContainer();
        System.out.println("Starting the Container");
        context=ejbContainer.getContext();
    }
    
    @AfterClass
    public static void tearDownClass() throws NamingException {
        context.close();
        System.out.println("Closing container");
    }
    
    @Test
    public void tester() throws NamingException{
        ManagerRemote rem=(ManagerRemote)context.lookup("metier.ManagerRemote");
        System.out.println(rem.sayHello());
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
