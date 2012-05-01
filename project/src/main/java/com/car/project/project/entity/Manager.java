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
@Table(name = "Manager", catalog = "WorkCar", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Manager.findAll", query = "SELECT m FROM Manager m"),
    @NamedQuery(name = "Manager.findById", query = "SELECT m FROM Manager m WHERE m.id = :id"),
    @NamedQuery(name = "Manager.findByLastName", query = "SELECT m FROM Manager m WHERE m.lastName = :lastName"),
    @NamedQuery(name = "Manager.findByFirstName", query = "SELECT m FROM Manager m WHERE m.firstName = :firstName"),
    @NamedQuery(name = "Manager.findByAddress", query = "SELECT m FROM Manager m WHERE m.address = :address"),
    @NamedQuery(name = "Manager.findByPhoneNumber", query = "SELECT m FROM Manager m WHERE m.phoneNumber = :phoneNumber")})
public class Manager implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LastName", nullable = false, length = 100)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "FirstName", nullable = false, length = 100)
    private String firstName;
    @Size(max = 200)
    @Column(name = "Address", length = 200)
    private String address;
    @Size(max = 20)
    @Column(name = "PhoneNumber", length = 20)
    private String phoneNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "managerid")
    private Collection<Order1> order1Collection;

    public Manager() {
    }

    public Manager(Integer id) {
        this.id = id;
    }

    public Manager(Integer id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @XmlTransient
    public Collection<Order1> getOrder1Collection() {
        return order1Collection;
    }

    public void setOrder1Collection(Collection<Order1> order1Collection) {
        this.order1Collection = order1Collection;
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
        if (!(object instanceof Manager)) {
            return false;
        }
        Manager other = (Manager) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.car.project.project.entity.Manager[ id=" + id + " ]";
    }
    
}
