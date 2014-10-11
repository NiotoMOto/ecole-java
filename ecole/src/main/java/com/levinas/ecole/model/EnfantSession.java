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
@Table(name = "enfant_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnfantSession.findAll", query = "SELECT e FROM EnfantSession e"),
    @NamedQuery(name = "EnfantSession.findByIdenfantSession", query = "SELECT e FROM EnfantSession e WHERE e.idenfantSession = :idenfantSession")})
public class EnfantSession implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idenfant_session")
    private Integer idenfantSession;
    @JoinColumn(name = "idinscription", referencedColumnName = "idinscription")
    @ManyToOne(optional = false)
    private Inscription idinscription;
    @JoinColumn(name = "idenfant", referencedColumnName = "id_enfant")
    @ManyToOne(optional = false)
    private Enfant idenfant;

    public EnfantSession() {
    }

    public EnfantSession(Integer idenfantSession) {
        this.idenfantSession = idenfantSession;
    }

    public Integer getIdenfantSession() {
        return idenfantSession;
    }

    public void setIdenfantSession(Integer idenfantSession) {
        this.idenfantSession = idenfantSession;
    }

    public Inscription getIdinscription() {
        return idinscription;
    }

    public void setIdinscription(Inscription idinscription) {
        this.idinscription = idinscription;
    }

    public Enfant getIdenfant() {
        return idenfant;
    }

    public void setIdenfant(Enfant idenfant) {
        this.idenfant = idenfant;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idenfantSession != null ? idenfantSession.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnfantSession)) {
            return false;
        }
        EnfantSession other = (EnfantSession) object;
        if ((this.idenfantSession == null && other.idenfantSession != null) || (this.idenfantSession != null && !this.idenfantSession.equals(other.idenfantSession))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.EnfantSession[ idenfantSession=" + idenfantSession + " ]";
    }
    
}
