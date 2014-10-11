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
@Table(name = "annee_scolaire_enfant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AnneeScolaireEnfant.findAll", query = "SELECT a FROM AnneeScolaireEnfant a"),
    @NamedQuery(name = "AnneeScolaireEnfant.findByIdanneeScolaireEnfant", query = "SELECT a FROM AnneeScolaireEnfant a WHERE a.idanneeScolaireEnfant = :idanneeScolaireEnfant")})
public class AnneeScolaireEnfant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idannee_scolaire_enfant")
    private Integer idanneeScolaireEnfant;
    @JoinColumn(name = "idetablissement", referencedColumnName = "idetablissement")
    @ManyToOne(optional = false)
    private Etablissement idetablissement;
    @JoinColumn(name = "idenfant", referencedColumnName = "id_enfant")
    @ManyToOne(optional = false)
    private Enfant idenfant;
    @JoinColumn(name = "idClasse", referencedColumnName = "idClasse")
    @ManyToOne(optional = false)
    private Classe idClasse;
    @JoinColumn(name = "idannee_scolaire", referencedColumnName = "idannee_scolaire")
    @ManyToOne(optional = false)
    private AnneeScolaire idanneeScolaire;

    public AnneeScolaireEnfant() {
    }

    public AnneeScolaireEnfant(Integer idanneeScolaireEnfant) {
        this.idanneeScolaireEnfant = idanneeScolaireEnfant;
    }

    public Integer getIdanneeScolaireEnfant() {
        return idanneeScolaireEnfant;
    }

    public void setIdanneeScolaireEnfant(Integer idanneeScolaireEnfant) {
        this.idanneeScolaireEnfant = idanneeScolaireEnfant;
    }

    public Etablissement getIdetablissement() {
        return idetablissement;
    }

    public void setIdetablissement(Etablissement idetablissement) {
        this.idetablissement = idetablissement;
    }

    public Enfant getIdenfant() {
        return idenfant;
    }

    public void setIdenfant(Enfant idenfant) {
        this.idenfant = idenfant;
    }

    public Classe getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Classe idClasse) {
        this.idClasse = idClasse;
    }

    public AnneeScolaire getIdanneeScolaire() {
        return idanneeScolaire;
    }

    public void setIdanneeScolaire(AnneeScolaire idanneeScolaire) {
        this.idanneeScolaire = idanneeScolaire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idanneeScolaireEnfant != null ? idanneeScolaireEnfant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnneeScolaireEnfant)) {
            return false;
        }
        AnneeScolaireEnfant other = (AnneeScolaireEnfant) object;
        if ((this.idanneeScolaireEnfant == null && other.idanneeScolaireEnfant != null) || (this.idanneeScolaireEnfant != null && !this.idanneeScolaireEnfant.equals(other.idanneeScolaireEnfant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.AnneeScolaireEnfant[ idanneeScolaireEnfant=" + idanneeScolaireEnfant + " ]";
    }
    
}
