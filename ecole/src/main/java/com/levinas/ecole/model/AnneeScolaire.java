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
 * @author Antone
 */
@Entity
@Table(name = "annee_scolaire")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnneeScolaire.findAll", query = "SELECT a FROM AnneeScolaire a"),
    @NamedQuery(name = "AnneeScolaire.findByIdanneeScolaire", query = "SELECT a FROM AnneeScolaire a WHERE a.idanneeScolaire = :idanneeScolaire"),
    @NamedQuery(name = "AnneeScolaire.findByLibelle", query = "SELECT a FROM AnneeScolaire a WHERE a.libelle = :libelle")})
public class AnneeScolaire implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idannee_scolaire")
    private Integer idanneeScolaire;
    @Size(max = 45)
    @Column(name = "libelle")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idanneeScolaire")
    private Collection<AnneeScolaireEnfant> anneeScolaireEnfantCollection;

    public AnneeScolaire() {
    }

    public AnneeScolaire(Integer idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    public Integer getIdanneeScolaire() {
        return idanneeScolaire;
    }

    public void setIdanneeScolaire(Integer idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AnneeScolaireEnfant> getAnneeScolaireEnfantCollection() {
        return anneeScolaireEnfantCollection;
    }

    public void setAnneeScolaireEnfantCollection(Collection<AnneeScolaireEnfant> anneeScolaireEnfantCollection) {
        this.anneeScolaireEnfantCollection = anneeScolaireEnfantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanneeScolaire != null ? idanneeScolaire.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnneeScolaire)) {
            return false;
        }
        AnneeScolaire other = (AnneeScolaire) object;
        if ((this.idanneeScolaire == null && other.idanneeScolaire != null) || (this.idanneeScolaire != null && !this.idanneeScolaire.equals(other.idanneeScolaire))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.AnneeScolaire[ idanneeScolaire=" + idanneeScolaire + " ]";
    }
    
}
