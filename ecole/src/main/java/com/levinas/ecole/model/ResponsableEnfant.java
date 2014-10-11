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
 * @author Administrateur
 */
@Entity
@Table(name = "responsable_enfant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResponsableEnfant.findAll", query = "SELECT r FROM ResponsableEnfant r"),
    @NamedQuery(name = "ResponsableEnfant.findByIdresponsableEnfant", query = "SELECT r FROM ResponsableEnfant r WHERE r.idresponsableEnfant = :idresponsableEnfant")})
public class ResponsableEnfant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idresponsable_enfant")
    private Integer idresponsableEnfant;
    @JoinColumn(name = "idtype_responsable", referencedColumnName = "idtype_responsable")
    @ManyToOne(optional = false)
    private TypeResponsable idtypeResponsable;
    @JoinColumn(name = "idresponsable", referencedColumnName = "idresponsable")
    @ManyToOne(optional = false)
    private Responsable idresponsable;
    @JoinColumn(name = "idenfant", referencedColumnName = "id_enfant")
    @ManyToOne(optional = false)
    private Enfant idenfant;

    public ResponsableEnfant() {
    }

    public ResponsableEnfant(Integer idresponsableEnfant) {
        this.idresponsableEnfant = idresponsableEnfant;
    }

    public Integer getIdresponsableEnfant() {
        return idresponsableEnfant;
    }

    public void setIdresponsableEnfant(Integer idresponsableEnfant) {
        this.idresponsableEnfant = idresponsableEnfant;
    }

    public TypeResponsable getIdtypeResponsable() {
        return idtypeResponsable;
    }

    public void setIdtypeResponsable(TypeResponsable idtypeResponsable) {
        this.idtypeResponsable = idtypeResponsable;
    }

    public Responsable getIdresponsable() {
        return idresponsable;
    }

    public void setIdresponsable(Responsable idresponsable) {
        this.idresponsable = idresponsable;
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
        hash += (idresponsableEnfant != null ? idresponsableEnfant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResponsableEnfant)) {
            return false;
        }
        ResponsableEnfant other = (ResponsableEnfant) object;
        if ((this.idresponsableEnfant == null && other.idresponsableEnfant != null) || (this.idresponsableEnfant != null && !this.idresponsableEnfant.equals(other.idresponsableEnfant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.ResponsableEnfant[ idresponsableEnfant=" + idresponsableEnfant + " ]";
    }
    
}
