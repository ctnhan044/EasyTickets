/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nhan Chau KP
 */
@Entity
@Table(name = "Program_Details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProgramDetails.findAll", query = "SELECT p FROM ProgramDetails p"),
    @NamedQuery(name = "ProgramDetails.findByProgramDetailId", query = "SELECT p FROM ProgramDetails p WHERE p.programDetailId = :programDetailId")})
public class ProgramDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "program_detail_id")
    private Integer programDetailId;
    @JoinColumn(name = "slot_id", referencedColumnName = "slot_id")
    @ManyToOne(optional = false)
    private ShowTime slotId;
    @JoinColumn(name = "room_id", referencedColumnName = "room_id")
    @ManyToOne(optional = false)
    private RoomStands roomId;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private Program programId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "programDetailId")
    private Collection<TicketDetails> ticketDetailsCollection;

    public ProgramDetails() {
    }

    public ProgramDetails(Integer programDetailId) {
        this.programDetailId = programDetailId;
    }

    public Integer getProgramDetailId() {
        return programDetailId;
    }

    public void setProgramDetailId(Integer programDetailId) {
        this.programDetailId = programDetailId;
    }

    public ShowTime getSlotId() {
        return slotId;
    }

    public void setSlotId(ShowTime slotId) {
        this.slotId = slotId;
    }

    public RoomStands getRoomId() {
        return roomId;
    }

    public void setRoomId(RoomStands roomId) {
        this.roomId = roomId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    @XmlTransient
    public Collection<TicketDetails> getTicketDetailsCollection() {
        return ticketDetailsCollection;
    }

    public void setTicketDetailsCollection(Collection<TicketDetails> ticketDetailsCollection) {
        this.ticketDetailsCollection = ticketDetailsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (programDetailId != null ? programDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProgramDetails)) {
            return false;
        }
        ProgramDetails other = (ProgramDetails) object;
        if ((this.programDetailId == null && other.programDetailId != null) || (this.programDetailId != null && !this.programDetailId.equals(other.programDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.ProgramDetails[ programDetailId=" + programDetailId + " ]";
    }
    
}
