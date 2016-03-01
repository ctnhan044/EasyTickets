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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Nhan Chau KP
 */
@Entity
@Table(name = "Room_Stands")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoomStands.findAll", query = "SELECT r FROM RoomStands r"),
    @NamedQuery(name = "RoomStands.findByRoomId", query = "SELECT r FROM RoomStands r WHERE r.roomId = :roomId"),
    @NamedQuery(name = "RoomStands.findByRoomName", query = "SELECT r FROM RoomStands r WHERE r.roomName = :roomName"),
    @NamedQuery(name = "RoomStands.findByNumberSeat", query = "SELECT r FROM RoomStands r WHERE r.numberSeat = :numberSeat")})
public class RoomStands implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "room_id")
    private String roomId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "room_name")
    private String roomName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "number_seat")
    private int numberSeat;
    @JoinColumn(name = "place_id", referencedColumnName = "place_id")
    @ManyToOne(optional = false)
    private Places placeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roomId")
    private Collection<ProgramDetails> programDetailsCollection;

    public RoomStands() {
    }

    public RoomStands(String roomId) {
        this.roomId = roomId;
    }

    public RoomStands(String roomId, String roomName, int numberSeat) {
        this.roomId = roomId;
        this.roomName = roomName;
        this.numberSeat = numberSeat;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getNumberSeat() {
        return numberSeat;
    }

    public void setNumberSeat(int numberSeat) {
        this.numberSeat = numberSeat;
    }

    public Places getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Places placeId) {
        this.placeId = placeId;
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
        hash += (roomId != null ? roomId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoomStands)) {
            return false;
        }
        RoomStands other = (RoomStands) object;
        if ((this.roomId == null && other.roomId != null) || (this.roomId != null && !this.roomId.equals(other.roomId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.RoomStands[ roomId=" + roomId + " ]";
    }
    
}
