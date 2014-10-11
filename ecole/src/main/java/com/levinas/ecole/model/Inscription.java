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
 * @author Antone
 */
@Entity
@Table(name = "inscription")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Inscription.findAll", query = "SELECT i FROM Inscription i"),
    @NamedQuery(name = "Inscription.findByIdinscription", query = "SELECT i FROM Inscription i WHERE i.idinscription = :idinscription"),
    @NamedQuery(name = "Inscription.findByPrix", query = "SELECT i FROM Inscription i WHERE i.prix = :prix")})
public class Inscription implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idinscription")
    private Integer idinscription;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "prix")
    private Float prix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idinscription")
    private Collection<EnfantSession> enfantSessionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inscriptionIdinscription")
    private Collection<JourSemaineInscritpion> jourSemaineInscritpionCollection;
    @JoinColumn(name = "periode_idperiode", referencedColumnName = "idperiode")
    @ManyToOne(optional = false)
    private Periode periodeIdperiode;
    @JoinColumn(name = "idactivite", referencedColumnName = "idactivite")
    @ManyToOne(optional = false)
    private Activite idactivite;

    public Inscription() {
    }

    public Inscription(Integer idinscription) {
        this.idinscription = idinscription;
    }

    public Integer getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Integer idinscription) {
        this.idinscription = idinscription;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EnfantSession> getEnfantSessionCollection() {
        return enfantSessionCollection;
    }

    public void setEnfantSessionCollection(Collection<EnfantSession> enfantSessionCollection) {
        this.enfantSessionCollection = enfantSessionCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<JourSemaineInscritpion> getJourSemaineInscritpionCollection() {
        return jourSemaineInscritpionCollection;
    }

    public void setJourSemaineInscritpionCollection(Collection<JourSemaineInscritpion> jourSemaineInscritpionCollection) {
        this.jourSemaineInscritpionCollection = jourSemaineInscritpionCollection;
    }

    public Periode getPeriodeIdperiode() {
        return periodeIdperiode;
    }

    public void setPeriodeIdperiode(Periode periodeIdperiode) {
        this.periodeIdperiode = periodeIdperiode;
    }

    public Activite getIdactivite() {
        return idactivite;
    }

    public void setIdactivite(Activite idactivite) {
        this.idactivite = idactivite;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idinscription != null ? idinscription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inscription)) {
            return false;
        }
        Inscription other = (Inscription) object;
        if ((this.idinscription == null && other.idinscription != null) || (this.idinscription != null && !this.idinscription.equals(other.idinscription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Inscription[ idinscription=" + idinscription + " ]";
    }
    
}
