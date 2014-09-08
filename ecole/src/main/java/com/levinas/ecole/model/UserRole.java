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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Administrateur
 */
@Entity
@Table(name = "user_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserRole.findAll", query = "SELECT u FROM UserRole u"),
    @NamedQuery(name = "UserRole.findByIduserRole", query = "SELECT u FROM UserRole u WHERE u.iduserRole = :iduserRole"),
    @NamedQuery(name = "UserRole.findByRole", query = "SELECT u FROM UserRole u WHERE u.role = :role")})
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iduser_role")
    private Integer iduserRole;
    @Size(max = 45)
    @Column(name = "role")
    private String role;
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User userIdUser;

    public UserRole() {
    }

    public UserRole(Integer iduserRole) {
        this.iduserRole = iduserRole;
    }

    public Integer getIduserRole() {
        return iduserRole;
    }

    public void setIduserRole(Integer iduserRole) {
        this.iduserRole = iduserRole;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(User userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iduserRole != null ? iduserRole.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserRole)) {
            return false;
        }
        UserRole other = (UserRole) object;
        if ((this.iduserRole == null && other.iduserRole != null) || (this.iduserRole != null && !this.iduserRole.equals(other.iduserRole))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.levinas.ecole.model.UserRole[ iduserRole=" + iduserRole + " ]";
    }
    
}
