/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author darkman
 */
@Entity
@NamedQueries({
  @NamedQuery(name="JoursFeries.findAll",
              query="SELECT JF FROM JoursFeries JF")
})
public class JoursFeries {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private java.util.Date date_bloque;
    private String fete;
    @ManyToOne
    private Planning planning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
    public Date getDate_bloque() {
        return date_bloque;
    }

    public void setDate_bloque(Date date_bloque) {
        this.date_bloque = date_bloque;
    }

    public String getFete() {
        return fete;
    }

    public void setFete(String fete) {
        this.fete = fete;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
    
    
    
}
