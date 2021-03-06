/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataNew;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author darkman
 */
@Entity
@NamedQueries({
  @NamedQuery(name="Structure.findAll",
              query="SELECT S FROM Structure S")
})
public class Structure implements Serializable{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
 private String nom_structure;  
 @Lob
 private Byte[] logo; 
 private String adresse;
 private String latitude;
 private String longitude;
 private String telephone;
 private String email;
 private String siteWeb;
 private String blog;
 @ManyToOne (cascade = CascadeType.REFRESH)
 private Ville ville;
 @OneToMany(mappedBy = "structure")
 private List <Service> services;
 @OneToMany(mappedBy = "structure")
 private List <Planning> plannings;
 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom_structure() {
        return nom_structure;
    }

    public void setNom_structure(String nom_structure) {
        this.nom_structure = nom_structure;
    }

    public Byte[] getLogo() {
        return logo;
    }

    public void setLogo(Byte[] logo) {
        this.logo = logo;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Planning> getPlannings() {
        return plannings;
    }

    public void setPlannings(List<Planning> plannings) {
        this.plannings = plannings;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Structure other = (Structure) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return  id + " " + nom_structure ;
    }
  
         
}
