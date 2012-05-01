/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmitriy
 */
@Entity
@Table(name = "Box", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Box.findAll", query = "SELECT b FROM Box b"),
    @NamedQuery(name = "Box.findById", query = "SELECT b FROM Box b WHERE b.id = :id"),
    @NamedQuery(name = "Box.findByTime", query = "SELECT b FROM Box b WHERE b.time = :time")})
public class Box implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "Time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @JoinColumn(name = "Status_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Status statusid;
    @JoinColumn(name = "Master_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Master masterid;

    public Box() {
    }

    public Box(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Status getStatusid() {
        return statusid;
    }

    public void setStatusid(Status statusid) {
        this.statusid = statusid;
    }

    public Master getMasterid() {
        return masterid;
    }

    public void setMasterid(Master masterid) {
        this.masterid = masterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Box)) {
            return false;
        }
        Box other = (Box) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.Box[ id=" + id + " ]";
    }
    
}
