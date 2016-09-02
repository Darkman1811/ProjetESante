/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.JoursFeriesUI;
import UI.RVUI;
import UI.MainWindow;
import data.JoursFeries;
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
public class JoursFeriesMetier {
  public void ajouter(JoursFeries joursFeries){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("insert into JoursFeries values (?,?,?,?)");
            prep.setInt(1,joursFeries.getId());
            prep.setDate(2,java.sql.Date.valueOf(joursFeries.getDate_bloque()));
            prep.setString(3, joursFeries.getFete());
            prep.setInt(4, 1);
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                JoursFeriesUI jfUI=new JoursFeriesUI();
                MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public void modifier(JoursFeries joursFeries){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("update JoursFeries  set date_bloque=?,fete=?,planningfk=? where id=?");
          
            prep.setDate(1,java.sql.Date.valueOf(joursFeries.getDate_bloque()));
            prep.setString(2, joursFeries.getFete());
            prep.setInt(3, 1);
            prep.setInt(4, joursFeries.getId());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                JoursFeriesUI jfUI=new JoursFeriesUI();
                MainWindow.mainLayout.setCenter(jfUI.getLayout()); 
  } 
  
  public ObservableList<JoursFeries>  getAll(){
      ObservableList<JoursFeries> pratiquants=FXCollections.observableArrayList();
        
      ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
                      String sql="select * from JoursFeries ";
                      Statement stat=conn.createStatement();
                      ResultSet result=stat.executeQuery(sql);
                    while(result.next()){
        JoursFeries joursFeries=new JoursFeries();
        joursFeries.setId(result.getInt(1));
        joursFeries.setDate_bloque(result.getDate(2).toLocalDate());
        joursFeries.setFete(result.getString(3));  
        pratiquants.add(joursFeries);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    return pratiquants;    
  }
}
