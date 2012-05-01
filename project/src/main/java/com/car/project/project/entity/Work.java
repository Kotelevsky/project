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
@Table(name = "Work", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Work.findAll", query = "SELECT w FROM Work w"),
    @NamedQuery(name = "Work.findById", query = "SELECT w FROM Work w WHERE w.workPK.id = :id"),
    @NamedQuery(name = "Work.findByCount", query = "SELECT w FROM Work w WHERE w.count = :count"),
    @NamedQuery(name = "Work.findBySpareid", query = "SELECT w FROM Work w WHERE w.workPK.spareid = :spareid")})
public class Work implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected WorkPK workPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Count", nullable = false)
    private int count;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "work")
    private Collection<ListWork> listWorkCollection;
    @JoinColumn(name = "Spare_id1", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Spare spareid1;

    public Work() {
    }

    public Work(WorkPK workPK) {
        this.workPK = workPK;
    }

    public Work(WorkPK workPK, int count) {
        this.workPK = workPK;
        this.count = count;
    }

    public Work(int id, int spareid) {
        this.workPK = new WorkPK(id, spareid);
    }

    public WorkPK getWorkPK() {
        return workPK;
    }

    public void setWorkPK(WorkPK workPK) {
        this.workPK = workPK;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlTransient
    public Collection<ListWork> getListWorkCollection() {
        return listWorkCollection;
    }

    public void setListWorkCollection(Collection<ListWork> listWorkCollection) {
        this.listWorkCollection = listWorkCollection;
    }

    public Spare getSpareid1() {
        return spareid1;
    }

    public void setSpareid1(Spare spareid1) {
        this.spareid1 = spareid1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (workPK != null ? workPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Work)) {
            return false;
        }
        Work other = (Work) object;
        if ((this.workPK == null && other.workPK != null) || (this.workPK != null && !this.workPK.equals(other.workPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.Work[ workPK=" + workPK + " ]";
    }
    
}
