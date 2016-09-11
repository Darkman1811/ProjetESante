/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Sync.DataSync;
import dataNew.JoursBloques;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author darkman
 */
@Path("/sync")
public class Rest {
    @GET
    @Path("/tester")
    @Produces(MediaType.TEXT_PLAIN)
    public String tester(){
        return "Test effectif";
    }
    
    /*
    @PUT
    @Path("/synctest")
    @Produces(MediaType.TEXT_PLAIN)
    public void syncJoursBloques(@QueryParam("jours") String para){
        System.out.println("para:"+para);
    }
   */
    @PUT
    @Path("/JoursBloques")
    @Produces(MediaType.APPLICATION_XML)
    public void syncJoursBloques(JoursBloques jb){
        System.out.println(jb.getId());
        System.out.println(jb.getDate_bloque());
        System.out.println(jb.getDebut_debut_bloque());
        System.out.println(jb.getDate_fin_bloque());
        System.out.println(jb.getRaison()); 
    }
    
    @PUT
    @Path("/ListJoursBloques")
    @Produces(MediaType.APPLICATION_XML)
  //  public void syncListJoursBloques(List<JoursBloques>  listeJoursBloques){
 public void syncListJoursBloques(DataSync  dataSync){
        System.out.println("Syncing data...");
         List<JoursBloques> lst=new ArrayList<JoursBloques>();
         lst=dataSync.getJoursBloques();
        Iterator it=lst.iterator();
        while (it.hasNext()){
            JoursBloques jb=(JoursBloques)it.next();
           
        System.out.println(jb.getId());
        System.out.println(jb.getDate_bloque());
        System.out.println(jb.getDebut_debut_bloque());
        System.out.println(jb.getDate_fin_bloque());
        System.out.println(jb.getRaison()); 
        
        System.out.println("-----------------------------------------");
        }
               
        
    }
}
