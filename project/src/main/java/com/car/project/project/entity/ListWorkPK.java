/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author dmitriy
 */
@Embeddable
public class ListWorkPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Status_id", nullable = false)
    private int statusid;

    public ListWorkPK() {
    }

    public ListWorkPK(int id, int statusid) {
        this.id = id;
        this.statusid = statusid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStatusid() {
        return statusid;
    }

    public void setStatusid(int statusid) {
        this.statusid = statusid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) statusid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ListWorkPK)) {
            return false;
        }
        ListWorkPK other = (ListWorkPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.statusid != other.statusid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.ListWorkPK[ id=" + id + ", statusid=" + statusid + " ]";
    }
    
}
