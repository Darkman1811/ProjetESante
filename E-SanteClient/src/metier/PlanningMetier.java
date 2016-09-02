/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.PlanningUI;
import UI.MainWindow;
import data.Planning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static metier.ConnectionEsante.connection;

/**
 *
 * @author darkman
 */
public class PlanningMetier {
  public void ajouter(Planning Planning){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("insert into PLANNING values (?,?,?,?,?)");
            prep.setInt(1,Planning.getId());
            prep.setString(2, Planning.getJours_de_semaine());
            prep.setTime(3, new java.sql.Time(Planning.getHeure_ouverture().getTime()));   
            prep.setTime(4, new java.sql.Time(Planning.getHeure_fermeture().getTime()));
            prep.setInt(5,1);
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                PlanningUI PlanningUI=new PlanningUI();
                MainWindow.mainLayout.setCenter(PlanningUI.getLayout()); 
  } 
  
  public void modifier(Planning Planning){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("update Planning  set prenom=?,nom=?,phone=?,email=?,age=?,civilite=? where id=?");
            prep.setInt(1,Planning.getId());
            prep.setString(2, Planning.getJours_de_semaine());
            prep.setTime(3, new java.sql.Time(Planning.getHeure_ouverture().getTime()));   
            prep.setTime(4, new java.sql.Time(Planning.getHeure_fermeture().getTime()));
           
            prep.setInt(5, Planning.getId());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                PlanningUI PlanningUI=new PlanningUI();
                MainWindow.mainLayout.setCenter(PlanningUI.getLayout()); 
  } 
  
  public ObservableList<Planning>  getAll(){
      ObservableList<Planning> Plannings=FXCollections.observableArrayList();
        
      ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
                      String sql="select * from Planning ";
                      Statement stat=conn.createStatement();
                      ResultSet result=stat.executeQuery(sql);
                    while(result.next()){
                      Planning pl=new Planning();
        pl.setId(result.getInt(1));
        pl.setJours_de_semaine(result.getString(2));
        java.sql.Time tmp=new java.sql.Time(result.getTime(3).getTime());
        pl.setHeure_ouverture(new java.util.Date(2016,18,11,tmp.getHours(),tmp.getMinutes(),tmp.getSeconds()));
        java.sql.Time tmp2=new java.sql.Time(result.getTime(4).getTime());
        pl.setHeure_fermeture(new java.util.Date(2016,18,11,tmp2.getHours(),tmp.getMinutes(),tmp.getSeconds()));
        Plannings.add(pl);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return Plannings;    
  }
}
