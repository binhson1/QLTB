/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Do Gia Huy
 */
@Entity
@Table(name = "device_maintenance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DeviceMaintenance.findAll", query = "SELECT d FROM DeviceMaintenance d"),
    @NamedQuery(name = "DeviceMaintenance.findById", query = "SELECT d FROM DeviceMaintenance d WHERE d.id = :id")})
public class DeviceMaintenance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @JoinColumn(name = "device_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Device deviceId;
    @JoinColumn(name = "schedule_maintenance_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Schedulemaintenance scheduleMaintenanceId;

    public DeviceMaintenance() {
    }

    public DeviceMaintenance(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Device getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Device deviceId) {
        this.deviceId = deviceId;
    }

    public Schedulemaintenance getScheduleMaintenanceId() {
        return scheduleMaintenanceId;
    }

    public void setScheduleMaintenanceId(Schedulemaintenance scheduleMaintenanceId) {
        this.scheduleMaintenanceId = scheduleMaintenanceId;
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
        if (!(object instanceof DeviceMaintenance)) {
            return false;
        }
        DeviceMaintenance other = (DeviceMaintenance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.husony.pojo.DeviceMaintenance[ id=" + id + " ]";
    }
    
}
