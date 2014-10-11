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
@Table(name = "etablissement")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etablissement.findAll", query = "SELECT e FROM Etablissement e"),
    @NamedQuery(name = "Etablissement.findByIdetablissement", query = "SELECT e FROM Etablissement e WHERE e.idetablissement = :idetablissement"),
    @NamedQuery(name = "Etablissement.findByLibelle", query = "SELECT e FROM Etablissement e WHERE e.libelle = :libelle"),
    @NamedQuery(name = "Etablissement.findByAdresse", query = "SELECT e FROM Etablissement e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Etablissement.findByCodePostal", query = "SELECT e FROM Etablissement e WHERE e.codePostal = :codePostal"),
    @NamedQuery(name = "Etablissement.findByVille", query = "SELECT e FROM Etablissement e WHERE e.ville = :ville"),
    @NamedQuery(name = "Etablissement.findByTelephone", query = "SELECT e FROM Etablissement e WHERE e.telephone = :telephone")})
public class Etablissement implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idetablissement")
    private Integer idetablissement;
    @Size(max = 45)
    @Column(name = "libelle")
    private String libelle;
    @Size(max = 45)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 45)
    @Column(name = "code_postal")
    private String codePostal;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @Size(max = 45)
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idetablissement")
    private Collection<AnneeScolaireEnfant> anneeScolaireEnfantCollection;

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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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
