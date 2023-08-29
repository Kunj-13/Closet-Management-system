/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author kxp5571
 */
@Entity
@Table(name = "CLOSETUSER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Closetuser.findAll", query = "SELECT c FROM Closetuser c")
    , @NamedQuery(name = "Closetuser.findByUserid", query = "SELECT c FROM Closetuser c WHERE c.userid = :userid")
    , @NamedQuery(name = "Closetuser.findByFirstname", query = "SELECT c FROM Closetuser c WHERE c.firstname = :firstname")
    , @NamedQuery(name = "Closetuser.findByLastname", query = "SELECT c FROM Closetuser c WHERE c.lastname = :lastname")})
public class Closetuser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USERID")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "FIRSTNAME")
    private String firstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LASTNAME")
    private String lastname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Closet> closetCollection;
    @OneToMany(mappedBy = "userid")
    private Collection<Accessory> accessoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userid")
    private Collection<Clothes> clothesCollection;

    public Closetuser() {
    }

    public Closetuser(Integer userid) {
        this.userid = userid;
    }

    public Closetuser(Integer userid, String firstname, String lastname) {
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @XmlTransient
    public Collection<Closet> getClosetCollection() {
        return closetCollection;
    }

    public void setClosetCollection(Collection<Closet> closetCollection) {
        this.closetCollection = closetCollection;
    }

    @XmlTransient
    public Collection<Accessory> getAccessoryCollection() {
        return accessoryCollection;
    }

    public void setAccessoryCollection(Collection<Accessory> accessoryCollection) {
        this.accessoryCollection = accessoryCollection;
    }

    @XmlTransient
    public Collection<Clothes> getClothesCollection() {
        return clothesCollection;
    }

    public void setClothesCollection(Collection<Clothes> clothesCollection) {
        this.clothesCollection = clothesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Closetuser)) {
            return false;
        }
        Closetuser other = (Closetuser) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return userid + " - " + firstname+" "+lastname ;
    }
    
}
