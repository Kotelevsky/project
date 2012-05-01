/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dmitriy
 */
@Entity
@Table(name = "ListWork", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ListWork.findAll", query = "SELECT l FROM ListWork l"),
    @NamedQuery(name = "ListWork.findById", query = "SELECT l FROM ListWork l WHERE l.listWorkPK.id = :id"),
    @NamedQuery(name = "ListWork.findByStatusid", query = "SELECT l FROM ListWork l WHERE l.listWorkPK.statusid = :statusid")})
public class ListWork implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ListWorkPK listWorkPK;
    @JoinColumn(name = "Order_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Order1 orderid;
    @JoinColumn(name = "Status_id1", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Status statusid1;
    @JoinColumns({
        @JoinColumn(name = "Work_id", referencedColumnName = "id", nullable = false),
        @JoinColumn(name = "Work_Spare_id", referencedColumnName = "Spare_id", nullable = false)})
    @ManyToOne(optional = false)
    private Work work;
    @JoinColumn(name = "Master_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Master masterid;

    public ListWork() {
    }

    public ListWork(ListWorkPK listWorkPK) {
        this.listWorkPK = listWorkPK;
    }

    public ListWork(int id, int statusid) {
        this.listWorkPK = new ListWorkPK(id, statusid);
    }

    public ListWorkPK getListWorkPK() {
        return listWorkPK;
    }

    public void setListWorkPK(ListWorkPK listWorkPK) {
        this.listWorkPK = listWorkPK;
    }

    public Order1 getOrderid() {
        return orderid;
    }

    public void setOrderid(Order1 orderid) {
        this.orderid = orderid;
    }

    public Status getStatusid1() {
        return statusid1;
    }

    public void setStatusid1(Status statusid1) {
        this.statusid1 = statusid1;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
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
        hash += (listWorkPK != null ? listWorkPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListWork)) {
            return false;
        }
        ListWork other = (ListWork) object;
        if ((this.listWorkPK == null && other.listWorkPK != null) || (this.listWorkPK != null && !this.listWorkPK.equals(other.listWorkPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.ListWork[ listWorkPK=" + listWorkPK + " ]";
    }
    
}
