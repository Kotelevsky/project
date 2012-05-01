/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dmitriy
 */
@Entity
@Table(name = "Spare", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Spare.findAll", query = "SELECT s FROM Spare s"),
    @NamedQuery(name = "Spare.findById", query = "SELECT s FROM Spare s WHERE s.id = :id"),
    @NamedQuery(name = "Spare.findByName", query = "SELECT s FROM Spare s WHERE s.name = :name"),
    @NamedQuery(name = "Spare.findByDescription", query = "SELECT s FROM Spare s WHERE s.description = :description"),
    @NamedQuery(name = "Spare.findByPrice", query = "SELECT s FROM Spare s WHERE s.price = :price")})
public class Spare implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Name", nullable = false, length = 200)
    private String name;
    @Size(max = 500)
    @Column(name = "Description", length = 500)
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price", nullable = false)
    private float price;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spareid")
    private Collection<OrderSpare> orderSpareCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spareid1")
    private Collection<Work> workCollection;

    public Spare() {
    }

    public Spare(Integer id) {
        this.id = id;
    }

    public Spare(Integer id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @XmlTransient
    public Collection<OrderSpare> getOrderSpareCollection() {
        return orderSpareCollection;
    }

    public void setOrderSpareCollection(Collection<OrderSpare> orderSpareCollection) {
        this.orderSpareCollection = orderSpareCollection;
    }

    @XmlTransient
    public Collection<Work> getWorkCollection() {
        return workCollection;
    }

    public void setWorkCollection(Collection<Work> workCollection) {
        this.workCollection = workCollection;
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
        if (!(object instanceof Spare)) {
            return false;
        }
        Spare other = (Spare) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.Spare[ id=" + id + " ]";
    }
    
}
