/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author kxp5571
 */
@Entity
@Table(name = "ACCESSORY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Accessory.findAll", query = "SELECT a FROM Accessory a")
    , @NamedQuery(name = "Accessory.findByAccessoryid", query = "SELECT a FROM Accessory a WHERE a.accessoryid = :accessoryid")
    , @NamedQuery(name = "Accessory.findByAccessorytype", query = "SELECT a FROM Accessory a WHERE a.accessorytype = :accessorytype")
    , @NamedQuery(name = "Accessory.findByColor", query = "SELECT a FROM Accessory a WHERE a.color = :color")})
public class Accessory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ACCESSORYID")
    private Integer accessoryid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ACCESSORYTYPE")
    private String accessorytype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COLOR")
    private String color;
    @JoinColumn(name = "CLOSETID", referencedColumnName = "CLOSETID")
    @ManyToOne
    private Closet closetid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne
    private Closetuser userid;

    public Accessory() {
    }

    public Accessory(Integer accessoryid) {
        this.accessoryid = accessoryid;
    }

    public Accessory(Integer accessoryid, String accessorytype, String color) {
        this.accessoryid = accessoryid;
        this.accessorytype = accessorytype;
        this.color = color;
    }

    public Integer getAccessoryid() {
        return accessoryid;
    }

    public void setAccessoryid(Integer accessoryid) {
        this.accessoryid = accessoryid;
    }

    public String getAccessorytype() {
        return accessorytype;
    }

    public void setAccessorytype(String accessorytype) {
        this.accessorytype = accessorytype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Closet getClosetid() {
        return closetid;
    }

    public void setClosetid(Closet closetid) {
        this.closetid = closetid;
    }

    public Closetuser getUserid() {
        return userid;
    }

    public void setUserid(Closetuser userid) {
        this.userid = userid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (accessoryid != null ? accessoryid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Accessory)) {
            return false;
        }
        Accessory other = (Accessory) object;
        if ((this.accessoryid == null && other.accessoryid != null) || (this.accessoryid != null && !this.accessoryid.equals(other.accessoryid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Accessory[ accessoryid=" + accessoryid + " ]";
    }
    
}
