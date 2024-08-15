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
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Do Gia Huy
 */
@Entity
@Table(name = "schedulerepair")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Schedulerepair.findAll", query = "SELECT s FROM Schedulerepair s"),
    @NamedQuery(name = "Schedulerepair.findById", query = "SELECT s FROM Schedulerepair s WHERE s.id = :id"),
    @NamedQuery(name = "Schedulerepair.findByDate", query = "SELECT s FROM Schedulerepair s WHERE s.date = :date"),
    @NamedQuery(name = "Schedulerepair.findByCost", query = "SELECT s FROM Schedulerepair s WHERE s.cost = :cost")})
public class Schedulerepair implements Serializable {

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
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cost")
    private double cost;
    @JoinColumn(name = "repair_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Repairtype repairTypeId;
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Report reportId;
    @OneToMany(mappedBy = "repairId")
    @JsonIgnore
    private Set<Job> jobSet;

    public Schedulerepair() {
    }

    public Schedulerepair(Long id) {
        this.id = id;
    }

    public Schedulerepair(Long id, Date date, double cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Repairtype getRepairTypeId() {
        return repairTypeId;
    }

    public void setRepairTypeId(Repairtype repairTypeId) {
        this.repairTypeId = repairTypeId;
    }

    public Report getReportId() {
        return reportId;
    }

    public void setReportId(Report reportId) {
        this.reportId = reportId;
    }

    @XmlTransient
    public Set<Job> getJobSet() {
        return jobSet;
    }

    public void setJobSet(Set<Job> jobSet) {
        this.jobSet = jobSet;
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
        if (!(object instanceof Schedulerepair)) {
            return false;
        }
        Schedulerepair other = (Schedulerepair) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.husony.pojo.Schedulerepair[ id=" + id + " ]";
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
}
