/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmitriy
 */
@Entity
@Table(name = "Order", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByDateReg", query = "SELECT o FROM Order1 o WHERE o.dateReg = :dateReg")})
public class Order1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateReg", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateReg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderid")
    private Collection<ListWork> listWorkCollection;
    @JoinColumn(name = "Manager_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Manager managerid;
    @JoinColumn(name = "Client_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Client clientid;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, Date dateReg) {
        this.id = id;
        this.dateReg = dateReg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateReg() {
        return dateReg;
    }

    public void setDateReg(Date dateReg) {
        this.dateReg = dateReg;
    }

    @XmlTransient
    public Collection<ListWork> getListWorkCollection() {
        return listWorkCollection;
    }

    public void setListWorkCollection(Collection<ListWork> listWorkCollection) {
        this.listWorkCollection = listWorkCollection;
    }

    public Manager getManagerid() {
        return managerid;
    }

    public void setManagerid(Manager managerid) {
        this.managerid = managerid;
    }

    public Client getClientid() {
        return clientid;
    }

    public void setClientid(Client clientid) {
        this.clientid = clientid;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.Order1[ id=" + id + " ]";
    }
    
}
