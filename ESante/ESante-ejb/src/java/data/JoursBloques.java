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
  @NamedQuery(name="JoursBloques.findAll",
              query="SELECT JB FROM JoursBloques JB")
})
public class JoursBloques {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date debut_debut_bloque;
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date date_fin_bloque;
    private String raison;
    @ManyToOne
    private Planning planning;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDebut_debut_bloque() {
        return debut_debut_bloque;
    }

    public void setDebut_debut_bloque(Date debut_debut_bloque) {
        this.debut_debut_bloque = debut_debut_bloque;
    }

    public Date getDate_fin_bloque() {
        return date_fin_bloque;
    }

    public void setDate_fin_bloque(Date date_fin_bloque) {
        this.date_fin_bloque = date_fin_bloque;
    }

    public String getRaison() {
        return raison;
    }

    public void setRaison(String raison) {
        this.raison = raison;
    }

    public Planning getPlanning() {
        return planning;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }
    
        
    
}
