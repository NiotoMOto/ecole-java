/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.levinas.ecole.model;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 *
 * @author Antone
 */
@Entity
@Table(name = "enfant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enfant.findAll", query = "SELECT e FROM Enfant e"),
    @NamedQuery(name = "Enfant.findByIdEnfant", query = "SELECT e FROM Enfant e WHERE e.idEnfant = :idEnfant"),
    @NamedQuery(name = "Enfant.findByNom", query = "SELECT e FROM Enfant e WHERE e.nom = :nom"),
    @NamedQuery(name = "Enfant.findByPrenom", query = "SELECT e FROM Enfant e WHERE e.prenom = :prenom"),
    @NamedQuery(name = "Enfant.findByBirthday", query = "SELECT e FROM Enfant e WHERE e.birthday = :birthday"),
    @NamedQuery(name = "Enfant.findByAdresse", query = "SELECT e FROM Enfant e WHERE e.adresse = :adresse"),
    @NamedQuery(name = "Enfant.findByVille", query = "SELECT e FROM Enfant e WHERE e.ville = :ville"),
    @NamedQuery(name = "Enfant.findByCodePostal", query = "SELECT e FROM Enfant e WHERE e.codePostal = :codePostal"),
    @NamedQuery(name = "Enfant.findBySecuSociale", query = "SELECT e FROM Enfant e WHERE e.secuSociale = :secuSociale"),
    @NamedQuery(name = "Enfant.findByAssuranceScolaire", query = "SELECT e FROM Enfant e WHERE e.assuranceScolaire = :assuranceScolaire")})
public class Enfant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_enfant")
    private Integer idEnfant;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "birthday")
    @Temporal(TemporalType.DATE)
    private Date birthday;
    @Size(max = 45)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @Size(max = 45)
    @Column(name = "code_postal")
    private String codePostal;
    @Lob
    @Size(max = 16777215)
    @Column(name = "aptitudes")
    private String aptitudes;
    @Lob
    @Size(max = 16777215)
    @Column(name = "difficultes")
    private String difficultes;
    @Lob
    @Size(max = 16777215)
    @Column(name = "commentaires")
    private String commentaires;
    @Column(name = "secu_sociale")
    private BigInteger secuSociale;
    @Column(name = "assurance_scolaire")
    private Boolean assuranceScolaire;
    @Lob
    @Size(max = 65535)
    @Column(name = "probleme_sante")
    private String problemeSante;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idenfant")
    private Collection<EnfantSession> enfantSessionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idenfant")
    private Collection<AnneeScolaireEnfant> anneeScolaireEnfantCollection;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User userIdUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idenfant")
    private Collection<ResponsableEnfant> responsableEnfantCollection;

    public Enfant() {
    }

    public Enfant(Integer idEnfant) {
        this.idEnfant = idEnfant;
    }

    public Integer getIdEnfant() {
        return idEnfant;
    }

    public void setIdEnfant(Integer idEnfant) {
        this.idEnfant = idEnfant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(String aptitudes) {
        this.aptitudes = aptitudes;
    }

    public String getDifficultes() {
        return difficultes;
    }

    public void setDifficultes(String difficultes) {
        this.difficultes = difficultes;
    }

    public String getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(String commentaires) {
        this.commentaires = commentaires;
    }

    public BigInteger getSecuSociale() {
        return secuSociale;
    }

    public void setSecuSociale(BigInteger secuSociale) {
        this.secuSociale = secuSociale;
    }

    public Boolean getAssuranceScolaire() {
        return assuranceScolaire;
    }

    public void setAssuranceScolaire(Boolean assuranceScolaire) {
        this.assuranceScolaire = assuranceScolaire;
    }

    public String getProblemeSante() {
        return problemeSante;
    }

    public void setProblemeSante(String problemeSante) {
        this.problemeSante = problemeSante;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<EnfantSession> getEnfantSessionCollection() {
        return enfantSessionCollection;
    }

    public void setEnfantSessionCollection(Collection<EnfantSession> enfantSessionCollection) {
        this.enfantSessionCollection = enfantSessionCollection;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<AnneeScolaireEnfant> getAnneeScolaireEnfantCollection() {
        return anneeScolaireEnfantCollection;
    }

    public void setAnneeScolaireEnfantCollection(Collection<AnneeScolaireEnfant> anneeScolaireEnfantCollection) {
        this.anneeScolaireEnfantCollection = anneeScolaireEnfantCollection;
    }

    public User getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(User userIdUser) {
        this.userIdUser = userIdUser;
    }

    @XmlTransient
    @JsonIgnore
    public Collection<ResponsableEnfant> getResponsableEnfantCollection() {
        return responsableEnfantCollection;
    }

    public void setResponsableEnfantCollection(Collection<ResponsableEnfant> responsableEnfantCollection) {
        this.responsableEnfantCollection = responsableEnfantCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEnfant != null ? idEnfant.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Enfant)) {
            return false;
        }
        Enfant other = (Enfant) object;
        if ((this.idEnfant == null && other.idEnfant != null) || (this.idEnfant != null && !this.idEnfant.equals(other.idEnfant))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Enfant[ idEnfant=" + idEnfant + " ]";
    }
    
}
