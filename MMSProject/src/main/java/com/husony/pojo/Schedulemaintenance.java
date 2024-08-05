/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Do Gia Huy
 */
@Entity
@Table(name = "schedulemaintenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedulemaintenance.findAll", query = "SELECT s FROM Schedulemaintenance s"),
    @NamedQuery(name = "Schedulemaintenance.findById", query = "SELECT s FROM Schedulemaintenance s WHERE s.id = :id"),
    @NamedQuery(name = "Schedulemaintenance.findByDate", query = "SELECT s FROM Schedulemaintenance s WHERE s.date = :date"),
    @NamedQuery(name = "Schedulemaintenance.findByFrequency", query = "SELECT s FROM Schedulemaintenance s WHERE s.frequency = :frequency")})
public class Schedulemaintenance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "frequency")
    private String frequency;
    @OneToMany(mappedBy = "maintenanceId")
    private Set<Job> jobSet;
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Device deviceId;
    @JoinColumn(name = "maintenance_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Maintenancetype maintenanceTypeId;

    public Schedulemaintenance() {
    }

    public Schedulemaintenance(Long id) {
        this.id = id;
    }

    public Schedulemaintenance(Long id, Date date, String frequency) {
        this.id = id;
        this.date = date;
        this.frequency = frequency;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @XmlTransient
    public Set<Job> getJobSet() {
        return jobSet;
    }

    public void setJobSet(Set<Job> jobSet) {
        this.jobSet = jobSet;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public Maintenancetype getMaintenanceTypeId() {
        return maintenanceTypeId;
    }

    public void setMaintenanceTypeId(Maintenancetype maintenanceTypeId) {
        this.maintenanceTypeId = maintenanceTypeId;
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
        if (!(object instanceof Schedulemaintenance)) {
            return false;
        }
        Schedulemaintenance other = (Schedulemaintenance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.husony.pojo.Schedulemaintenance[ id=" + id + " ]";
    }
    
}
