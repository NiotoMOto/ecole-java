/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "periode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Periode.findAll", query = "SELECT p FROM Periode p"),
    @NamedQuery(name = "Periode.findByIdperiode", query = "SELECT p FROM Periode p WHERE p.idperiode = :idperiode"),
    @NamedQuery(name = "Periode.findByDebut", query = "SELECT p FROM Periode p WHERE p.debut = :debut"),
    @NamedQuery(name = "Periode.findByFin", query = "SELECT p FROM Periode p WHERE p.fin = :fin")})
public class Periode implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperiode")
    private Integer idperiode;
    @Column(name = "debut")
    @Temporal(TemporalType.TIMESTAMP)
    private Date debut;
    @Column(name = "fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodeIdperiode")
    private List<Inscription> inscriptionList;

    public Periode() {
    }

    public Periode(Integer idperiode) {
        this.idperiode = idperiode;
    }

    public Integer getIdperiode() {
        return idperiode;
    }

    public void setIdperiode(Integer idperiode) {
        this.idperiode = idperiode;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    @XmlTransient
    @JsonIgnore
    public List<Inscription> getInscriptionList() {
        return inscriptionList;
    }

    public void setInscriptionList(List<Inscription> inscriptionList) {
        this.inscriptionList = inscriptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idperiode != null ? idperiode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periode)) {
            return false;
        }
        Periode other = (Periode) object;
        if ((this.idperiode == null && other.idperiode != null) || (this.idperiode != null && !this.idperiode.equals(other.idperiode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Periode[ idperiode=" + idperiode + " ]";
    }
    
}
