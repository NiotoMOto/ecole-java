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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Antone
 */
@Entity
@Table(name = "paiement_du")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaiementDu.findAll", query = "SELECT p FROM PaiementDu p"),
    @NamedQuery(name = "PaiementDu.findByIdpaiementDu", query = "SELECT p FROM PaiementDu p WHERE p.idpaiementDu = :idpaiementDu")})
public class PaiementDu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpaiement_du")
    private Integer idpaiementDu;

    public PaiementDu() {
    }

    public PaiementDu(Integer idpaiementDu) {
        this.idpaiementDu = idpaiementDu;
    }

    public Integer getIdpaiementDu() {
        return idpaiementDu;
    }

    public void setIdpaiementDu(Integer idpaiementDu) {
        this.idpaiementDu = idpaiementDu;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpaiementDu != null ? idpaiementDu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaiementDu)) {
            return false;
        }
        PaiementDu other = (PaiementDu) object;
        if ((this.idpaiementDu == null && other.idpaiementDu != null) || (this.idpaiementDu != null && !this.idpaiementDu.equals(other.idpaiementDu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.PaiementDu[ idpaiementDu=" + idpaiementDu + " ]";
    }
    
}
