/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nhan Chau KP
 */
@Entity
@Table(name = "Ticket_Details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TicketDetails.findAll", query = "SELECT t FROM TicketDetails t"),
    @NamedQuery(name = "TicketDetails.findByTicketId", query = "SELECT t FROM TicketDetails t WHERE t.ticketId = :ticketId"),
    @NamedQuery(name = "TicketDetails.findBySeatNo", query = "SELECT t FROM TicketDetails t WHERE t.seatNo = :seatNo")})
public class TicketDetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ticket_id")
    private Integer ticketId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "seat_no")
    private int seatNo;
    @JoinColumn(name = "program_detail_id", referencedColumnName = "program_detail_id")
    @ManyToOne(optional = false)
    private ProgramDetails programDetailId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;

    public TicketDetails() {
    }

    public TicketDetails(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public TicketDetails(Integer ticketId, int seatNo) {
        this.ticketId = ticketId;
        this.seatNo = seatNo;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int seatNo) {
        this.seatNo = seatNo;
    }

    public ProgramDetails getProgramDetailId() {
        return programDetailId;
    }

    public void setProgramDetailId(ProgramDetails programDetailId) {
        this.programDetailId = programDetailId;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ticketId != null ? ticketId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TicketDetails)) {
            return false;
        }
        TicketDetails other = (TicketDetails) object;
        if ((this.ticketId == null && other.ticketId != null) || (this.ticketId != null && !this.ticketId.equals(other.ticketId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.TicketDetails[ ticketId=" + ticketId + " ]";
    }
    
}
