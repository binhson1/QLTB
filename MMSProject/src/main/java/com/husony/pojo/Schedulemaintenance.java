/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
    @NamedQuery(name = "Schedulemaintenance.findByLastMaintenanceDate", query = "SELECT s FROM Schedulemaintenance s WHERE s.lastMaintenanceDate = :lastMaintenanceDate"),
    @NamedQuery(name = "Schedulemaintenance.findByNextMaintenanceDate", query = "SELECT s FROM Schedulemaintenance s WHERE s.nextMaintenanceDate = :nextMaintenanceDate"),
    @NamedQuery(name = "Schedulemaintenance.findByIntervalMonth", query = "SELECT s FROM Schedulemaintenance s WHERE s.intervalMonth = :intervalMonth")})
public class Schedulemaintenance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Column(name = "last_maintenance_date")
    @Temporal(TemporalType.DATE)
    private Date lastMaintenanceDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "next_maintenance_date")
    @Temporal(TemporalType.DATE)
    private Date nextMaintenanceDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "interval_month")
    private int intervalMonth;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "scheduleMaintenanceId")
    @JsonIgnore
    private Set<DeviceMaintenance> deviceMaintenanceSet;
    @OneToMany(mappedBy = "maintenanceId")
    @JsonIgnore
    private Set<Job> jobSet;
    @JoinColumn(name = "maintenance_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Maintenancetype maintenanceTypeId;

    public Schedulemaintenance() {
    }

    public Schedulemaintenance(Long id) {
        this.id = id;
    }

    public Schedulemaintenance(Long id, Date nextMaintenanceDate, int intervalMonth, String name) {
        this.id = id;
        this.nextMaintenanceDate = nextMaintenanceDate;
        this.intervalMonth = intervalMonth;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastMaintenanceDate() {
        return lastMaintenanceDate;
    }

    public void setLastMaintenanceDate(Date lastMaintenanceDate) {
        this.lastMaintenanceDate = lastMaintenanceDate;
    }

    public Date getNextMaintenanceDate() {
        return nextMaintenanceDate;
    }

    public void setNextMaintenanceDate(Date nextMaintenanceDate) {
        this.nextMaintenanceDate = nextMaintenanceDate;
    }

    public int getIntervalMonth() {
        return intervalMonth;
    }

    public void setIntervalMonth(int intervalMonth) {
        this.intervalMonth = intervalMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Set<DeviceMaintenance> getDeviceMaintenanceSet() {
        return deviceMaintenanceSet;
    }

    public void setDeviceMaintenanceSet(Set<DeviceMaintenance> deviceMaintenanceSet) {
        this.deviceMaintenanceSet = deviceMaintenanceSet;
    }

    @XmlTransient
    public Set<Job> getJobSet() {
        return jobSet;
    }

    public void setJobSet(Set<Job> jobSet) {
        this.jobSet = jobSet;
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
