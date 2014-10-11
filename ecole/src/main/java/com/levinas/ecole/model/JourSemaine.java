/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.model;

import java.io.Serializable;
import java.util.Collection;
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
 * @author Antone
 */
@Entity
@Table(name = "jour_semaine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JourSemaine.findAll", query = "SELECT j FROM JourSemaine j"),
    @NamedQuery(name = "JourSemaine.findByIdjour", query = "SELECT j FROM JourSemaine j WHERE j.idjour = :idjour"),
    @NamedQuery(name = "JourSemaine.findByJour", query = "SELECT j FROM JourSemaine j WHERE j.jour = :jour")})
public class JourSemaine implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjour")
    private Integer idjour;
    @Size(max = 45)
    @Column(name = "jour")
    private String jour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jourSemaineIdjour")
    private Collection<JourSemaineInscritpion> jourSemaineInscritpionCollection;

    public JourSemaine() {
    }

    public JourSemaine(Integer idjour) {
        this.idjour = idjour;
    }

    public Integer getIdjour() {
        return idjour;
    }

    public void setIdjour(Integer idjour) {
        this.idjour = idjour;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<JourSemaineInscritpion> getJourSemaineInscritpionCollection() {
        return jourSemaineInscritpionCollection;
    }

    public void setJourSemaineInscritpionCollection(Collection<JourSemaineInscritpion> jourSemaineInscritpionCollection) {
        this.jourSemaineInscritpionCollection = jourSemaineInscritpionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjour != null ? idjour.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JourSemaine)) {
            return false;
        }
        JourSemaine other = (JourSemaine) object;
        if ((this.idjour == null && other.idjour != null) || (this.idjour != null && !this.idjour.equals(other.idjour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.JourSemaine[ idjour=" + idjour + " ]";
    }
    
}
