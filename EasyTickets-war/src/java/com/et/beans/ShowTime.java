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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nhan Chau KP
 */
@Entity
@Table(name = "Show_Time")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShowTime.findAll", query = "SELECT s FROM ShowTime s"),
    @NamedQuery(name = "ShowTime.findBySlotId", query = "SELECT s FROM ShowTime s WHERE s.slotId = :slotId"),
    @NamedQuery(name = "ShowTime.findByStartTime", query = "SELECT s FROM ShowTime s WHERE s.startTime = :startTime")})
public class ShowTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "slot_id")
    private Integer slotId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "slotId")
    private Collection<ProgramDetails> programDetailsCollection;

    public ShowTime() {
    }

    public ShowTime(Integer slotId) {
        this.slotId = slotId;
    }

    public ShowTime(Integer slotId, Date startTime) {
        this.slotId = slotId;
        this.startTime = startTime;
    }

    public Integer getSlotId() {
        return slotId;
    }

    public void setSlotId(Integer slotId) {
        this.slotId = slotId;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    @XmlTransient
    public Collection<ProgramDetails> getProgramDetailsCollection() {
        return programDetailsCollection;
    }

    public void setProgramDetailsCollection(Collection<ProgramDetails> programDetailsCollection) {
        this.programDetailsCollection = programDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (slotId != null ? slotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShowTime)) {
            return false;
        }
        ShowTime other = (ShowTime) object;
        if ((this.slotId == null && other.slotId != null) || (this.slotId != null && !this.slotId.equals(other.slotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.ShowTime[ slotId=" + slotId + " ]";
    }
    
}
