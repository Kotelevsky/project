/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmitriy
 */
@Entity
@Table(name = "Warehouse", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Warehouse.findAll", query = "SELECT w FROM Warehouse w"),
    @NamedQuery(name = "Warehouse.findById", query = "SELECT w FROM Warehouse w WHERE w.id = :id")})
public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "warehouseid")
    private Collection<OrderSpare> orderSpareCollection;

    public Warehouse() {
    }

    public Warehouse(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<OrderSpare> getOrderSpareCollection() {
        return orderSpareCollection;
    }

    public void setOrderSpareCollection(Collection<OrderSpare> orderSpareCollection) {
        this.orderSpareCollection = orderSpareCollection;
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
        if (!(object instanceof Warehouse)) {
            return false;
        }
        Warehouse other = (Warehouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.Warehouse[ id=" + id + " ]";
    }
    
}
