/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antone
 */
@Entity
@Table(name = "jour_semaine_inscritpion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JourSemaineInscritpion.findAll", query = "SELECT j FROM JourSemaineInscritpion j"),
    @NamedQuery(name = "JourSemaineInscritpion.findByIdjourSemaineInscritpion", query = "SELECT j FROM JourSemaineInscritpion j WHERE j.idjourSemaineInscritpion = :idjourSemaineInscritpion")})
public class JourSemaineInscritpion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idjour_semaine_inscritpion")
    private Integer idjourSemaineInscritpion;
    @JoinColumn(name = "jour_semaine_idjour", referencedColumnName = "idjour")
    @ManyToOne(optional = false)
    private JourSemaine jourSemaineIdjour;
    @JoinColumn(name = "inscription_idinscription", referencedColumnName = "idinscription")
    @ManyToOne(optional = false)
    private Inscription inscriptionIdinscription;

    public JourSemaineInscritpion() {
    }

    public JourSemaineInscritpion(Integer idjourSemaineInscritpion) {
        this.idjourSemaineInscritpion = idjourSemaineInscritpion;
    }

    public Integer getIdjourSemaineInscritpion() {
        return idjourSemaineInscritpion;
    }

    public void setIdjourSemaineInscritpion(Integer idjourSemaineInscritpion) {
        this.idjourSemaineInscritpion = idjourSemaineInscritpion;
    }

    public JourSemaine getJourSemaineIdjour() {
        return jourSemaineIdjour;
    }

    public void setJourSemaineIdjour(JourSemaine jourSemaineIdjour) {
        this.jourSemaineIdjour = jourSemaineIdjour;
    }

    public Inscription getInscriptionIdinscription() {
        return inscriptionIdinscription;
    }

    public void setInscriptionIdinscription(Inscription inscriptionIdinscription) {
        this.inscriptionIdinscription = inscriptionIdinscription;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idjourSemaineInscritpion != null ? idjourSemaineInscritpion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JourSemaineInscritpion)) {
            return false;
        }
        JourSemaineInscritpion other = (JourSemaineInscritpion) object;
        if ((this.idjourSemaineInscritpion == null && other.idjourSemaineInscritpion != null) || (this.idjourSemaineInscritpion != null && !this.idjourSemaineInscritpion.equals(other.idjourSemaineInscritpion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.JourSemaineInscritpion[ idjourSemaineInscritpion=" + idjourSemaineInscritpion + " ]";
    }
    
}
