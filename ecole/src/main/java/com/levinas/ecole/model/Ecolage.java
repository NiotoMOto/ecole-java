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
 * @author Administrateur
 */
@Entity
@Table(name = "ecolage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ecolage.findAll", query = "SELECT e FROM Ecolage e"),
    @NamedQuery(name = "Ecolage.findByIdecolage", query = "SELECT e FROM Ecolage e WHERE e.idecolage = :idecolage")})
public class Ecolage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idecolage")
    private Integer idecolage;

    public Ecolage() {
    }

    public Ecolage(Integer idecolage) {
        this.idecolage = idecolage;
    }

    public Integer getIdecolage() {
        return idecolage;
    }

    public void setIdecolage(Integer idecolage) {
        this.idecolage = idecolage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idecolage != null ? idecolage.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ecolage)) {
            return false;
        }
        Ecolage other = (Ecolage) object;
        if ((this.idecolage == null && other.idecolage != null) || (this.idecolage != null && !this.idecolage.equals(other.idecolage))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Ecolage[ idecolage=" + idecolage + " ]";
    }
    
}
