/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.RVUI;
import UI.MainWindow;
import data.RV;
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
public class RVMetier {
  public void ajouter(RV rv){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("insert into RV values (?,?,?,?,?,?,?,?,?)");
            prep.setInt(1,rv.getId());
            prep.setDate(2,java.sql.Date.valueOf(rv.getDateRV()));
            prep.setTime(3,java.sql.Time.valueOf(rv.getHeureDebutRV()));
            prep.setTime(4,java.sql.Time.valueOf(rv.getHeureFinRV()));
            prep.setString(5, rv.getEtat());
            prep.setString(6, rv.getCodeRV());
            prep.setInt(7,1);
            prep.setInt(8, 1);
            prep.setInt(9, 1);
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                RVUI pratiquantUI=new RVUI();
                MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public void modifier(RV rv){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("update RV  set daterv=?,heuredebutrv=?,heurefinrv=?,etat=?,coderv=?,planningfk=?,clientfk=?,pratiquantfk=? where id=?");
          
            prep.setDate(1,java.sql.Date.valueOf(rv.getDateRV()));
            prep.setTime(2,java.sql.Time.valueOf(rv.getHeureDebutRV()));
            prep.setTime(3,java.sql.Time.valueOf(rv.getHeureFinRV()));
            prep.setString(4, rv.getEtat());
            prep.setString(5, rv.getCodeRV());
            prep.setInt(6, new Integer(1));
            prep.setInt(7, new Integer(1));
            prep.setInt(8, new Integer(1));
            prep.setInt(9, rv.getId());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                RVUI pratiquantUI=new RVUI();
                MainWindow.mainLayout.setCenter(pratiquantUI.getLayout()); 
  } 
  
  public ObservableList<RV>  getAll(){
      ObservableList<RV> pratiquants=FXCollections.observableArrayList();
        
      ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
                      String sql="select * from RV ";
                      Statement stat=conn.createStatement();
                      ResultSet result=stat.executeQuery(sql);
                    while(result.next()){
        RV rv=new RV();
        rv.setId(result.getInt(1));
        rv.setDateRV(result.getDate(2).toLocalDate());
        rv.setHeureDebutRV(result.getTime(3).toLocalTime());
        rv.setHeureFinRV(result.getTime(4).toLocalTime());
        rv.setEtat(result.getString(5));        
        rv.setCodeRV(result.getString(6));
        pratiquants.add(rv);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
        
    return pratiquants;    
  }
}
