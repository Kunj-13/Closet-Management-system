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
@Table(name = "CLOTHES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clothes.findAll", query = "SELECT c FROM Clothes c")
    , @NamedQuery(name = "Clothes.findByClotheid", query = "SELECT c FROM Clothes c WHERE c.clotheid = :clotheid")
    , @NamedQuery(name = "Clothes.findByClothetype", query = "SELECT c FROM Clothes c WHERE c.clothetype = :clothetype")
    , @NamedQuery(name = "Clothes.findByColor", query = "SELECT c FROM Clothes c WHERE c.color = :color")
    , @NamedQuery(name = "Clothes.findByClothesize", query = "SELECT c FROM Clothes c WHERE c.clothesize = :clothesize")})
public class Clothes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CLOTHEID")
    private Integer clotheid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CLOTHETYPE")
    private String clothetype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "CLOTHESIZE")
    private String clothesize;
    @JoinColumn(name = "CLOSETID", referencedColumnName = "CLOSETID")
    @ManyToOne(optional = false)
    private Closet closetid;
    @JoinColumn(name = "USERID", referencedColumnName = "USERID")
    @ManyToOne(optional = false)
    private Closetuser userid;

    public Clothes() {
    }

    public Clothes(Integer clotheid) {
        this.clotheid = clotheid;
    }

    public Clothes(Integer clotheid, String clothetype, String color, String clothesize) {
        this.clotheid = clotheid;
        this.clothetype = clothetype;
        this.color = color;
        this.clothesize = clothesize;
    }

    public Integer getClotheid() {
        return clotheid;
    }

    public void setClotheid(Integer clotheid) {
        this.clotheid = clotheid;
    }

    public String getClothetype() {
        return clothetype;
    }

    public void setClothetype(String clothetype) {
        this.clothetype = clothetype;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getClothesize() {
        return clothesize;
    }

    public void setClothesize(String clothesize) {
        this.clothesize = clothesize;
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
        hash += (clotheid != null ? clotheid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clothes)) {
            return false;
        }
        Clothes other = (Clothes) object;
        if ((this.clotheid == null && other.clotheid != null) || (this.clotheid != null && !this.clotheid.equals(other.clotheid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jpa.entities.Clothes[ clotheid=" + clotheid + " ]";
    }
    
}
