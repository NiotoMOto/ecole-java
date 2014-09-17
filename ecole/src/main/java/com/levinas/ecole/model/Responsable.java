/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Responsable.findAll", query = "SELECT r FROM Responsable r"),
    @NamedQuery(name = "Responsable.findByIdresponsable", query = "SELECT r FROM Responsable r WHERE r.idresponsable = :idresponsable"),
    @NamedQuery(name = "Responsable.findByNom", query = "SELECT r FROM Responsable r WHERE r.nom = :nom"),
    @NamedQuery(name = "Responsable.findByPrenom", query = "SELECT r FROM Responsable r WHERE r.prenom = :prenom"),
    @NamedQuery(name = "Responsable.findByAdresse", query = "SELECT r FROM Responsable r WHERE r.adresse = :adresse"),
    @NamedQuery(name = "Responsable.findByVille", query = "SELECT r FROM Responsable r WHERE r.ville = :ville"),
    @NamedQuery(name = "Responsable.search", query = "SELECT r FROM Responsable r WHERE r.nom like :search OR r.prenom like :search OR r.adresse like search OR r.ville like :search OR r.codePostale like :search"),
    @NamedQuery(name = "Responsable.findByCodePostale", query = "SELECT r FROM Responsable r WHERE r.codePostale = :codePostale")})
public class Responsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresponsable")
    private Integer idresponsable;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 45)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @Size(max = 45)
    @Column(name = "code_postale")
    private String codePostale;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idresponsable")
    private List<ResponsableEnfant> responsableEnfantList;

    public Responsable() {
    }

    public Responsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    public Integer getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Integer idresponsable) {
        this.idresponsable = idresponsable;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(String codePostale) {
        this.codePostale = codePostale;
    }

    @XmlTransient
    @JsonIgnore
    public List<ResponsableEnfant> getResponsableEnfantList() {
        return responsableEnfantList;
    }

    public void setResponsableEnfantList(List<ResponsableEnfant> responsableEnfantList) {
        this.responsableEnfantList = responsableEnfantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idresponsable != null ? idresponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Responsable)) {
            return false;
        }
        Responsable other = (Responsable) object;
        if ((this.idresponsable == null && other.idresponsable != null) || (this.idresponsable != null && !this.idresponsable.equals(other.idresponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Responsable[ idresponsable=" + idresponsable + " ]";
    }
    
}
