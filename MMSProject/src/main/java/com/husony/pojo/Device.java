/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

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
@Table(name = "device")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Device.findAll", query = "SELECT d FROM Device d"),
    @NamedQuery(name = "Device.findById", query = "SELECT d FROM Device d WHERE d.id = :id"),
    @NamedQuery(name = "Device.findByName", query = "SELECT d FROM Device d WHERE d.name = :name"),
    @NamedQuery(name = "Device.findByBoughtDate", query = "SELECT d FROM Device d WHERE d.boughtDate = :boughtDate"),
    @NamedQuery(name = "Device.findByStatus", query = "SELECT d FROM Device d WHERE d.status = :status")})
public class Device implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "descriptions")
    private String descriptions;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bought_date")
    @Temporal(TemporalType.DATE)
    private Date boughtDate;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private Set<Report> reportSet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private Set<Locationhistory> locationhistorySet;
    @JoinColumn(name = "device_category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Devicecategory deviceCategoryId;
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Manufacturer manufacturerId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deviceId")
    private Set<Schedulemaintenance> schedulemaintenanceSet;

    public Device() {
    }

    public Device(Long id) {
        this.id = id;
    }

    public Device(Long id, String name, String image, String descriptions, Date boughtDate) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.descriptions = descriptions;
        this.boughtDate = boughtDate;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Date getBoughtDate() {
        return boughtDate;
    }

    public void setBoughtDate(Date boughtDate) {
        this.boughtDate = boughtDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @XmlTransient
    public Set<Report> getReportSet() {
        return reportSet;
    }

    public void setReportSet(Set<Report> reportSet) {
        this.reportSet = reportSet;
    }

    @XmlTransient
    public Set<Locationhistory> getLocationhistorySet() {
        return locationhistorySet;
    }

    public void setLocationhistorySet(Set<Locationhistory> locationhistorySet) {
        this.locationhistorySet = locationhistorySet;
    }

    public Devicecategory getDeviceCategoryId() {
        return deviceCategoryId;
    }

    public void setDeviceCategoryId(Devicecategory deviceCategoryId) {
        this.deviceCategoryId = deviceCategoryId;
    }

    public Manufacturer getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(Manufacturer manufacturerId) {
        this.manufacturerId = manufacturerId;
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
        if (!(object instanceof Device)) {
            return false;
        }
        Device other = (Device) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.husony.pojo.Device[ id=" + id + " ]";
    }
    
}
