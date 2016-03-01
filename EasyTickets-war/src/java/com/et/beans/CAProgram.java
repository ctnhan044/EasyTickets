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
@Table(name = "CA_Program")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CAProgram.findAll", query = "SELECT c FROM CAProgram c"),
    @NamedQuery(name = "CAProgram.findByCaProgramId", query = "SELECT c FROM CAProgram c WHERE c.caProgramId = :caProgramId")})
public class CAProgram implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ca_program_id")
    private Integer caProgramId;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id")
    @ManyToOne(optional = false)
    private Program programId;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private Category catId;

    public CAProgram() {
    }

    public CAProgram(Integer caProgramId) {
        this.caProgramId = caProgramId;
    }

    public Integer getCaProgramId() {
        return caProgramId;
    }

    public void setCaProgramId(Integer caProgramId) {
        this.caProgramId = caProgramId;
    }

    public Program getProgramId() {
        return programId;
    }

    public void setProgramId(Program programId) {
        this.programId = programId;
    }

    public Category getCatId() {
        return catId;
    }

    public void setCatId(Category catId) {
        this.catId = catId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caProgramId != null ? caProgramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CAProgram)) {
            return false;
        }
        CAProgram other = (CAProgram) object;
        if ((this.caProgramId == null && other.caProgramId != null) || (this.caProgramId != null && !this.caProgramId.equals(other.caProgramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.CAProgram[ caProgramId=" + caProgramId + " ]";
    }
    
}
