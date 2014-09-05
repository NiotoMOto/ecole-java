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
@Table(name = "type_responsable")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeResponsable.findAll", query = "SELECT t FROM TypeResponsable t"),
    @NamedQuery(name = "TypeResponsable.findByIdtypeResponsable", query = "SELECT t FROM TypeResponsable t WHERE t.idtypeResponsable = :idtypeResponsable"),
    @NamedQuery(name = "TypeResponsable.findByLibelle", query = "SELECT t FROM TypeResponsable t WHERE t.libelle = :libelle")})
public class TypeResponsable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtype_responsable")
    private Integer idtypeResponsable;
    @Size(max = 45)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypeResponsable")
    private List<ResponsableEnfant> responsableEnfantList;

    public TypeResponsable() {
    }

    public TypeResponsable(Integer idtypeResponsable) {
        this.idtypeResponsable = idtypeResponsable;
    }

    public Integer getIdtypeResponsable() {
        return idtypeResponsable;
    }

    public void setIdtypeResponsable(Integer idtypeResponsable) {
        this.idtypeResponsable = idtypeResponsable;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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
        hash += (idtypeResponsable != null ? idtypeResponsable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeResponsable)) {
            return false;
        }
        TypeResponsable other = (TypeResponsable) object;
        if ((this.idtypeResponsable == null && other.idtypeResponsable != null) || (this.idtypeResponsable != null && !this.idtypeResponsable.equals(other.idtypeResponsable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.TypeResponsable[ idtypeResponsable=" + idtypeResponsable + " ]";
    }
    
}
