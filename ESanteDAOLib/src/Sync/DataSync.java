/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sync;

import dataNew.JoursBloques;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author darkman
 */
@XmlRootElement
public class DataSync implements Serializable{
    private List<JoursBloques> joursBloques;

    public List<JoursBloques> getJoursBloques() {
        return joursBloques;
    }

    public void setJoursBloques(List<JoursBloques> joursBloques) {
        this.joursBloques = joursBloques;
    }
   
    
    
    
}
