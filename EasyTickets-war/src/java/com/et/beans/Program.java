/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
 * @author Nhan Chau KP
 */
@Entity
@Table(name = "Program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Program.findAll", query = "SELECT p FROM Program p"),
    @NamedQuery(name = "Program.findByProgramId", query = "SELECT p FROM Program p WHERE p.programId = :programId"),
    @NamedQuery(name = "Program.findByName", query = "SELECT p FROM Program p WHERE p.name = :name"),
    @NamedQuery(name = "Program.findByCoverPhoto", query = "SELECT p FROM Program p WHERE p.coverPhoto = :coverPhoto"),
    @NamedQuery(name = "Program.findByStartDate", query = "SELECT p FROM Program p WHERE p.startDate = :startDate"),
    @NamedQuery(name = "Program.findByLength", query = "SELECT p FROM Program p WHERE p.length = :length"),
    @NamedQuery(name = "Program.findByPointRate", query = "SELECT p FROM Program p WHERE p.pointRate = :pointRate"),
    @NamedQuery(name = "Program.findByTypeId", query = "SELECT p FROM Program p WHERE p.typeId = :typeId")})
public class Program implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "program_id")
    private Integer programId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "cover_photo")
    private String coverPhoto;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length")
    private int length;
    @Basic(optional = false)
    @NotNull
    @Column(name = "point_rate")
    private double pointRate;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "type_id")
    private String typeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<ProgramDetails> programDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "program")
    private Collection<MostViews> mostViewsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programId")
    private Collection<CAProgram> cAProgramCollection;

    public Program() {
    }

    public Program(Integer programId) {
        this.programId = programId;
    }

    public Program(Integer programId, String name, String coverPhoto, String description, Date startDate, int length, double pointRate, String typeId) {
        this.programId = programId;
        this.name = name;
        this.coverPhoto = coverPhoto;
        this.description = description;
        this.startDate = startDate;
        this.length = length;
        this.pointRate = pointRate;
        this.typeId = typeId;
    }

    public Integer getProgramId() {
        return programId;
    }

    public void setProgramId(Integer programId) {
        this.programId = programId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(String coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getPointRate() {
        return pointRate;
    }

    public void setPointRate(double pointRate) {
        this.pointRate = pointRate;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    @XmlTransient
    public Collection<ProgramDetails> getProgramDetailsCollection() {
        return programDetailsCollection;
    }

    public void setProgramDetailsCollection(Collection<ProgramDetails> programDetailsCollection) {
        this.programDetailsCollection = programDetailsCollection;
    }

    @XmlTransient
    public Collection<MostViews> getMostViewsCollection() {
        return mostViewsCollection;
    }

    public void setMostViewsCollection(Collection<MostViews> mostViewsCollection) {
        this.mostViewsCollection = mostViewsCollection;
    }

    @XmlTransient
    public Collection<CAProgram> getCAProgramCollection() {
        return cAProgramCollection;
    }

    public void setCAProgramCollection(Collection<CAProgram> cAProgramCollection) {
        this.cAProgramCollection = cAProgramCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programId != null ? programId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Program)) {
            return false;
        }
        Program other = (Program) object;
        if ((this.programId == null && other.programId != null) || (this.programId != null && !this.programId.equals(other.programId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.Program[ programId=" + programId + " ]";
    }
    
}
