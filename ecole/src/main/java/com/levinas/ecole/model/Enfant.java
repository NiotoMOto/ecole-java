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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "enfant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfant.findAll", query = "SELECT e FROM Enfant e"),
    @NamedQuery(name = "Enfant.findByIdEnfant", query = "SELECT e FROM Enfant e WHERE e.idEnfant = :idEnfant"),
    @NamedQuery(name = "Enfant.findByNom", query = "SELECT e FROM Enfant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enfant.search", query = "SELECT e FROM Enfant e WHERE e.nom like :search OR e.prenom like :search"),
    @NamedQuery(name = "Enfant.findByPrenom", query = "SELECT e FROM Enfant e WHERE e.prenom = :prenom")})

public class Enfant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enfant")
    private Integer idEnfant;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idenfant")
    private List<EnfantSession> enfantSessionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idenfant")
    private List<AnneeScolaireEnfant> anneeScolaireEnfantList;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User userIdUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idenfant")
    private List<ResponsableEnfant> responsableEnfantList;

    public Enfant() {
    }

    public Enfant(Integer idEnfant) {
        this.idEnfant = idEnfant;
    }

    public Integer getIdEnfant() {
        return idEnfant;
    }

    public void setIdEnfant(Integer idEnfant) {
        this.idEnfant = idEnfant;
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

    @XmlTransient
    @JsonIgnore
    public List<EnfantSession> getEnfantSessionList() {
        return enfantSessionList;
    }

    public void setEnfantSessionList(List<EnfantSession> enfantSessionList) {
        this.enfantSessionList = enfantSessionList;
    }

    @XmlTransient
    @JsonIgnore
    public List<AnneeScolaireEnfant> getAnneeScolaireEnfantList() {
        return anneeScolaireEnfantList;
    }

    public void setAnneeScolaireEnfantList(List<AnneeScolaireEnfant> anneeScolaireEnfantList) {
        this.anneeScolaireEnfantList = anneeScolaireEnfantList;
    }

    public User getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(User userIdUser) {
        this.userIdUser = userIdUser;
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
        hash += (idEnfant != null ? idEnfant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfant)) {
            return false;
        }
        Enfant other = (Enfant) object;
        if ((this.idEnfant == null && other.idEnfant != null) || (this.idEnfant != null && !this.idEnfant.equals(other.idEnfant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Enfant[ idEnfant=" + idEnfant + " ]";
    }
    
}
