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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e"),
    @NamedQuery(name = "Etablissement.findByIdetablissement", query = "SELECT e FROM Etablissement e WHERE e.idetablissement = :idetablissement")})
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetablissement")
    private Integer idetablissement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetablissement")
    private List<AnneeScolaireEnfant> anneeScolaireEnfantList;

    public Etablissement() {
    }

    public Etablissement(Integer idetablissement) {
        this.idetablissement = idetablissement;
    }

    public Integer getIdetablissement() {
        return idetablissement;
    }

    public void setIdetablissement(Integer idetablissement) {
        this.idetablissement = idetablissement;
    }

    @XmlTransient
    @JsonIgnore
    public List<AnneeScolaireEnfant> getAnneeScolaireEnfantList() {
        return anneeScolaireEnfantList;
    }

    public void setAnneeScolaireEnfantList(List<AnneeScolaireEnfant> anneeScolaireEnfantList) {
        this.anneeScolaireEnfantList = anneeScolaireEnfantList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idetablissement != null ? idetablissement.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etablissement)) {
            return false;
        }
        Etablissement other = (Etablissement) object;
        if ((this.idetablissement == null && other.idetablissement != null) || (this.idetablissement != null && !this.idetablissement.equals(other.idetablissement))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Etablissement[ idetablissement=" + idetablissement + " ]";
    }
    
}
