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
@Table(name = "jour")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jour.findAll", query = "SELECT j FROM Jour j"),
    @NamedQuery(name = "Jour.findByIdjour", query = "SELECT j FROM Jour j WHERE j.idjour = :idjour"),
    @NamedQuery(name = "Jour.findByJour", query = "SELECT j FROM Jour j WHERE j.jour = :jour")})
public class Jour implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjour")
    private Integer idjour;
    @Size(max = 45)
    @Column(name = "jour")
    private String jour;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jourFin")
    private List<PeriodeJours> periodeJoursList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "jourDebut")
    private List<PeriodeJours> periodeJoursList1;

    public Jour() {
    }

    public Jour(Integer idjour) {
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
    public List<PeriodeJours> getPeriodeJoursList() {
        return periodeJoursList;
    }

    public void setPeriodeJoursList(List<PeriodeJours> periodeJoursList) {
        this.periodeJoursList = periodeJoursList;
    }

    @XmlTransient
    @JsonIgnore
    public List<PeriodeJours> getPeriodeJoursList1() {
        return periodeJoursList1;
    }

    public void setPeriodeJoursList1(List<PeriodeJours> periodeJoursList1) {
        this.periodeJoursList1 = periodeJoursList1;
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
        if (!(object instanceof Jour)) {
            return false;
        }
        Jour other = (Jour) object;
        if ((this.idjour == null && other.idjour != null) || (this.idjour != null && !this.idjour.equals(other.idjour))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Jour[ idjour=" + idjour + " ]";
    }
    
}
