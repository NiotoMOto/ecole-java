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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "personnel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personnel.findAll", query = "SELECT p FROM Personnel p"),
    @NamedQuery(name = "Personnel.findByIdpersonnel", query = "SELECT p FROM Personnel p WHERE p.idpersonnel = :idpersonnel"),
    @NamedQuery(name = "Personnel.findByNom", query = "SELECT p FROM Personnel p WHERE p.nom = :nom"),
    @NamedQuery(name = "Personnel.findByPrenom", query = "SELECT p FROM Personnel p WHERE p.prenom = :prenom"),
    @NamedQuery(name = "Personnel.findByAdresse", query = "SELECT p FROM Personnel p WHERE p.adresse = :adresse"),
    @NamedQuery(name = "Personnel.findByVille", query = "SELECT p FROM Personnel p WHERE p.ville = :ville"),
    @NamedQuery(name = "Personnel.findByCodepostal", query = "SELECT p FROM Personnel p WHERE p.codepostal = :codepostal"),
    @NamedQuery(name = "Personnel.findByTelephone", query = "SELECT p FROM Personnel p WHERE p.telephone = :telephone"),
    @NamedQuery(name = "Personnel.findByMobile", query = "SELECT p FROM Personnel p WHERE p.mobile = :mobile"),
    @NamedQuery(name = "Personnel.search", query = "SELECT p FROM Personnel p WHERE p.mobile like :search OR p.fonction like :search OR p.nom like :search OR p.prenom like :search OR p.adresse like :search or p.ville like search or p.codepostal like :search"),
    @NamedQuery(name = "Personnel.findByFonction", query = "SELECT p FROM Personnel p WHERE p.fonction = :fonction")})
public class Personnel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpersonnel")
    private Integer idpersonnel;
    @Size(max = 45)
    @Column(name = "nom")
    private String nom;
    @Size(max = 45)
    @Column(name = "prenom")
    private String prenom;
    @Size(max = 45)
    @Column(name = "adresse")
    private String adresse;
    @Size(max = 45)
    @Column(name = "ville")
    private String ville;
    @Size(max = 45)
    @Column(name = "codepostal")
    private String codepostal;
    @Size(max = 45)
    @Column(name = "telephone")
    private String telephone;
    @Size(max = 45)
    @Column(name = "mobile")
    private String mobile;
    @Size(max = 45)
    @Column(name = "fonction")
    private String fonction;

    public Personnel() {
    }

    public Personnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
    }

    public Integer getIdpersonnel() {
        return idpersonnel;
    }

    public void setIdpersonnel(Integer idpersonnel) {
        this.idpersonnel = idpersonnel;
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

    public String getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(String codepostal) {
        this.codepostal = codepostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpersonnel != null ? idpersonnel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personnel)) {
            return false;
        }
        Personnel other = (Personnel) object;
        if ((this.idpersonnel == null && other.idpersonnel != null) || (this.idpersonnel != null && !this.idpersonnel.equals(other.idpersonnel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.Personnel[ idpersonnel=" + idpersonnel + " ]";
    }
    
}
