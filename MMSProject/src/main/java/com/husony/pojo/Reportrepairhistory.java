/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.husony.pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Do Gia Huy
 */
@Entity
@Table(name = "reportrepairhistory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Reportrepairhistory.findAll", query = "SELECT r FROM Reportrepairhistory r"),
    @NamedQuery(name = "Reportrepairhistory.findById", query = "SELECT r FROM Reportrepairhistory r WHERE r.id = :id"),
    @NamedQuery(name = "Reportrepairhistory.findByCreatedDate", query = "SELECT r FROM Reportrepairhistory r WHERE r.createdDate = :createdDate")})
public class Reportrepairhistory implements Serializable {

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
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "content")
    private String content;
    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;
    @JoinColumn(name = "device_category_id", referencedColumnName = "id")
    @ManyToOne
    private Devicecategory deviceCategoryId;
    @JoinColumn(name = "report_id", referencedColumnName = "id")
    @ManyToOne
    private Report reportId;

    public Reportrepairhistory() {
    }

    public Reportrepairhistory(Long id) {
        this.id = id;
    }

    public Reportrepairhistory(Long id, String title, String content, Date createdDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Devicecategory getDeviceCategoryId() {
        return deviceCategoryId;
    }

    public void setDeviceCategoryId(Devicecategory deviceCategoryId) {
        this.deviceCategoryId = deviceCategoryId;
    }

    public Report getReportId() {
        return reportId;
    }

    public void setReportId(Report reportId) {
        this.reportId = reportId;
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
        if (!(object instanceof Reportrepairhistory)) {
            return false;
        }
        Reportrepairhistory other = (Reportrepairhistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.husony.pojo.Reportrepairhistory[ id=" + id + " ]";
    }
    
}
