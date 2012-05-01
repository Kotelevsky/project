/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmitriy
 */
@Entity
@Table(name = "OrderSpare", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderSpare.findAll", query = "SELECT o FROM OrderSpare o"),
    @NamedQuery(name = "OrderSpare.findById", query = "SELECT o FROM OrderSpare o WHERE o.id = :id"),
    @NamedQuery(name = "OrderSpare.findByCount", query = "SELECT o FROM OrderSpare o WHERE o.count = :count")})
public class OrderSpare implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Count", precision = 6, scale = 2)
    private Float count;
    @JoinColumn(name = "Spare_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Spare spareid;
    @JoinColumn(name = "Warehouse_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Warehouse warehouseid;
    @JoinColumn(name = "Master_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Master masterid;

    public OrderSpare() {
    }

    public OrderSpare(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getCount() {
        return count;
    }

    public void setCount(Float count) {
        this.count = count;
    }

    public Spare getSpareid() {
        return spareid;
    }

    public void setSpareid(Spare spareid) {
        this.spareid = spareid;
    }

    public Warehouse getWarehouseid() {
        return warehouseid;
    }

    public void setWarehouseid(Warehouse warehouseid) {
        this.warehouseid = warehouseid;
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
        if (!(object instanceof OrderSpare)) {
            return false;
        }
        OrderSpare other = (OrderSpare) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.OrderSpare[ id=" + id + " ]";
    }
    
}
