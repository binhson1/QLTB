/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Do Gia Huy
 */
@Entity
@Table(name = "maintenancetype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Maintenancetype.findAll", query = "SELECT m FROM Maintenancetype m"),
    @NamedQuery(name = "Maintenancetype.findById", query = "SELECT m FROM Maintenancetype m WHERE m.id = :id")})
public class Maintenancetype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maintenanceTypeId")
    @JsonIgnore
    private Set<Schedulemaintenance> schedulemaintenanceSet;

    public Maintenancetype() {
    }

    public Maintenancetype(Long id) {
        this.id = id;
    }

    public Maintenancetype(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<Schedulemaintenance> getSchedulemaintenanceSet() {
        return schedulemaintenanceSet;
    }

    public void setSchedulemaintenanceSet(Set<Schedulemaintenance> schedulemaintenanceSet) {
        this.schedulemaintenanceSet = schedulemaintenanceSet;
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
        if (!(object instanceof Maintenancetype)) {
            return false;
        }
        Maintenancetype other = (Maintenancetype) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.husony.pojo.Maintenancetype[ id=" + id + " ]";
    }
    
}
