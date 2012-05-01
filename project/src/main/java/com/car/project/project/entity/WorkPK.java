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
public class WorkPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private int id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Spare_id", nullable = false)
    private int spareid;

    public WorkPK() {
    }

    public WorkPK(int id, int spareid) {
        this.id = id;
        this.spareid = spareid;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpareid() {
        return spareid;
    }

    public void setSpareid(int spareid) {
        this.spareid = spareid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (int) spareid;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WorkPK)) {
            return false;
        }
        WorkPK other = (WorkPK) object;
        if (this.id != other.id) {
            return false;
        }
        if (this.spareid != other.spareid) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.WorkPK[ id=" + id + ", spareid=" + spareid + " ]";
    }
    
}
