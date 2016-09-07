/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import UI.ClientUI;
import UI.MainWindow;
import data.Client;
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
public class ClientMetier {
  public void ajouter(Client client){
      /*
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("insert into CLIENT values (?,?,?,?,?,?,?)");
            prep.setInt(1,client.getId());
            prep.setString(2, client.getPrenom());
            prep.setString(3, client.getNom());
            prep.setString(4, client.getPhone());
            prep.setString(5, client.getEmail());
            prep.setInt(6, new Integer(client.getAge()));
            prep.setString(7, client.getCivilite());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
              */
      
                ClientUI clientUI=new ClientUI();
                MainWindow.mainLayout.setCenter(clientUI.getLayout()); 
  } 
  
  public void modifier(Client client){
      
        ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
            PreparedStatement prep=conn.prepareStatement("update CLIENT  set prenom=?,nom=?,phone=?,email=?,age=?,civilite=? where id=?");
           // prep.setInt(1, client.getId());
            prep.setString(1, client.getPrenom());
            prep.setString(2, client.getNom());
            prep.setString(3, client.getPhone());
            prep.setString(4, client.getEmail());
            prep.setInt(5, new Integer(client.getAge()));
            prep.setString(6, client.getCivilite());
            prep.setInt(7, client.getId());
            prep.executeUpdate();
         
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
                ClientUI clientUI=new ClientUI();
                MainWindow.mainLayout.setCenter(clientUI.getLayout()); 
  } 
  
  public ObservableList<Client>  getAll(){
      ObservableList<Client> clients=FXCollections.observableArrayList();
        
      ConnectionEsante fact=new ConnectionEsante();
        Connection conn= fact.getConnection();
                  try {
                      String sql="select * from CLIENT ";
                      Statement stat=conn.createStatement();
                      ResultSet result=stat.executeQuery(sql);
                    while(result.next()){
                      Client c=new Client();
        c.setAge(result.getString(6));
        c.setCivilite(result.getString(7));
        c.setEmail(result.getString(5));
        c.setId(result.getInt(1));
        c.setNom(result.getString(3));
        c.setPrenom(result.getString(2));
        c.setPhone(result.getString(4));
        clients.add(c);
                    }
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionEsante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    return clients;    
  }
}
