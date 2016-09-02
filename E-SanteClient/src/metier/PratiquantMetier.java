/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.PratiquantUI;
import UI.MainWindow;
import data.Pratiquant;
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
public class PratiquantMetier {
  public void ajouter(Pratiquant pratiquant){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("insert into PRATIQUANT values (?,?,?,?,?,?,?)");
            prep.setInt(1,pratiquant.getId());
            prep.setString(2, pratiquant.getPrenom());
            prep.setString(3, pratiquant.getNom());
            prep.setString(4, pratiquant.getTitre());
            prep.setString(5, pratiquant.getSpecialite());
            prep.setString(6, pratiquant.getCivilite());
            prep.setInt(7, new Integer(pratiquant.getAge()));
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                PratiquantUI pratiquantUI=new PratiquantUI();
                MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public void modifier(Pratiquant pratiquant){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("update PRATIQUANT  set prenom=?,nom=?,titre=?,specialite=?,age=?,civilite=? where id=?");
           // prep.setInt(1, pratiquant.getId());
            prep.setString(1, pratiquant.getPrenom());
            prep.setString(2, pratiquant.getNom());
            prep.setString(3, pratiquant.getTitre());
            prep.setString(4, pratiquant.getSpecialite());
            prep.setInt(5, new Integer(pratiquant.getAge()));
            prep.setString(6, pratiquant.getCivilite());
            prep.setInt(7, pratiquant.getId());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                PratiquantUI pratiquantUI=new PratiquantUI();
                MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public ObservableList<Pratiquant>  getAll(){
      ObservableList<Pratiquant> pratiquants=FXCollections.observableArrayList();
        
      ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
                      String sql="select * from PRATIQUANT ";
                      Statement stat=conn.createStatement();
                      ResultSet result=stat.executeQuery(sql);
                    while(result.next()){
                      Pratiquant p=new Pratiquant();
        p.setId(result.getInt(1));
        p.setPrenom(result.getString(2));
        p.setNom(result.getString(3));
        p.setTitre(result.getString(4));
        p.setSpecialite(result.getString(5));        
        p.setCivilite(result.getString(6));
        p.setAge(result.getString(7));
        pratiquants.add(p);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return pratiquants;    
  }
}
