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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "periode_jours")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeriodeJours.findAll", query = "SELECT p FROM PeriodeJours p"),
    @NamedQuery(name = "PeriodeJours.findByIdperiodeJours", query = "SELECT p FROM PeriodeJours p WHERE p.idperiodeJours = :idperiodeJours")})
public class PeriodeJours implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperiode_jours")
    private Integer idperiodeJours;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodeJoursIdperiodeJours")
    private Collection<Inscription> inscriptionCollection;
    @JoinColumn(name = "jour_fin", referencedColumnName = "idjour")
    @ManyToOne(optional = false)
    private Jour jourFin;
    @JoinColumn(name = "jour_debut", referencedColumnName = "idjour")
    @ManyToOne(optional = false)
    private Jour jourDebut;

    public PeriodeJours() {
    }

    public PeriodeJours(Integer idperiodeJours) {
        this.idperiodeJours = idperiodeJours;
    }

    public Integer getIdperiodeJours() {
        return idperiodeJours;
    }

    public void setIdperiodeJours(Integer idperiodeJours) {
        this.idperiodeJours = idperiodeJours;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<Inscription> getInscriptionCollection() {
        return inscriptionCollection;
    }

    public void setInscriptionCollection(Collection<Inscription> inscriptionCollection) {
        this.inscriptionCollection = inscriptionCollection;
    }

    public Jour getJourFin() {
        return jourFin;
    }

    public void setJourFin(Jour jourFin) {
        this.jourFin = jourFin;
    }

    public Jour getJourDebut() {
        return jourDebut;
    }

    public void setJourDebut(Jour jourDebut) {
        this.jourDebut = jourDebut;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiodeJours != null ? idperiodeJours.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeriodeJours)) {
            return false;
        }
        PeriodeJours other = (PeriodeJours) object;
        if ((this.idperiodeJours == null && other.idperiodeJours != null) || (this.idperiodeJours != null && !this.idperiodeJours.equals(other.idperiodeJours))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.PeriodeJours[ idperiodeJours=" + idperiodeJours + " ]";
    }
    
}
