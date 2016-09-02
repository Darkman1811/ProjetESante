/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.JoursBloquesUI;
import UI.RVUI;
import UI.MainWindow;
import data.JoursBloques;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
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
public class JoursBloquesMetier {
  public void ajouter(JoursBloques joursBloques){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("insert into JoursBloques values (?,?,?,?,?,?)");
            prep.setInt(1,joursBloques.getId());
            prep.setDate(2,java.sql.Date.valueOf(joursBloques.getDate_bloque()));
            prep.setTime(3,java.sql.Time.valueOf(joursBloques.getDebut_debut_bloque()));
            prep.setTime(4, java.sql.Time.valueOf(joursBloques.getDate_fin_bloque()));
            prep.setString(5, joursBloques.getRaison());
            prep.setInt(6, 1);
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                JoursBloquesUI jfUI=new JoursBloquesUI();
                MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public void modifier(JoursBloques joursBloques){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("update JoursBloques  set date_bloque=?,debut_heure_bloque=?,fin_heure_bloque=?,raison=?,planningfk=? where id=?");
          
            prep.setDate(1,java.sql.Date.valueOf(joursBloques.getDate_bloque()));
            prep.setTime(2,java.sql.Time.valueOf(joursBloques.getDebut_debut_bloque()));
            prep.setTime(3, java.sql.Time.valueOf(joursBloques.getDate_fin_bloque()));
            prep.setString(4, joursBloques.getRaison());
            prep.setInt(5, 1);
            prep.setInt(6,joursBloques.getId());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                JoursBloquesUI jfUI=new JoursBloquesUI();
                MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public ObservableList<JoursBloques>  getAll(){
      ObservableList<JoursBloques> pratiquants=FXCollections.observableArrayList();
        
      ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
                      String sql="select * from JoursBloques ";
                      Statement stat=conn.createStatement();
                      ResultSet result=stat.executeQuery(sql);
                    while(result.next()){
        JoursBloques joursBloques=new JoursBloques();
        joursBloques.setId(result.getInt(1));
        joursBloques.setDate_bloque(result.getDate(2).toLocalDate());
        joursBloques.setDebut_debut_bloque(result.getTime(3).toLocalTime()); 
        joursBloques.setDate_fin_bloque(result.getTime(4).toLocalTime());
        joursBloques.setRaison(result.getString(5));
        pratiquants.add(joursBloques);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    return pratiquants;    
  }
}
