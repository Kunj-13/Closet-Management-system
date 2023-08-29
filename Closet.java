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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "CLOSET")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Closet.findAll", query = "SELECT c FROM Closet c")
    , @NamedQuery(name = "Closet.findByClosetid", query = "SELECT c FROM Closet c WHERE c.closetid = :closetid")
    , @NamedQuery(name = "Closet.findByLocation", query = "SELECT c FROM Closet c WHERE c.location = :location")
    , @NamedQuery(name = "Closet.findByClosetsize", query = "SELECT c FROM Closet c WHERE c.closetsize = :closetsize")})
public class Closet implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLOSETID")
    private Integer closetid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "LOCATION")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CLOSETSIZE")
    private String closetsize;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Closetuser userid;
    @OneToMany(mappedBy = "closetid")
    private Collection<Accessory> accessoryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "closetid")
    private Collection<Clothes> clothesCollection;

    public Closet() {
    }

    public Closet(Integer closetid) {
        this.closetid = closetid;
    }

    public Closet(Integer closetid, String location, String closetsize) {
        this.closetid = closetid;
        this.location = location;
        this.closetsize = closetsize;
    }

    public Integer getClosetid() {
        return closetid;
    }

    public void setClosetid(Integer closetid) {
        this.closetid = closetid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getClosetsize() {
        return closetsize;
    }

    public void setClosetsize(String closetsize) {
        this.closetsize = closetsize;
    }

    public Closetuser getUserid() {
        return userid;
    }

    public void setUserid(Closetuser userid) {
        this.userid = userid;
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
        hash += (closetid != null ? closetid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Closet)) {
            return false;
        }
        Closet other = (Closet) object;
        if ((this.closetid == null && other.closetid != null) || (this.closetid != null && !this.closetid.equals(other.closetid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return closetid + " - " + location + " - " + closetsize + " - " + userid;
    }
    
}
