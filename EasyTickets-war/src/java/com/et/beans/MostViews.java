/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "Most_Views")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MostViews.findAll", query = "SELECT m FROM MostViews m"),
    @NamedQuery(name = "MostViews.findByCustomerId", query = "SELECT m FROM MostViews m WHERE m.mostViewsPK.customerId = :customerId"),
    @NamedQuery(name = "MostViews.findByProgramId", query = "SELECT m FROM MostViews m WHERE m.mostViewsPK.programId = :programId"),
    @NamedQuery(name = "MostViews.findByView", query = "SELECT m FROM MostViews m WHERE m.view = :view"),
    @NamedQuery(name = "MostViews.findByFavorite", query = "SELECT m FROM MostViews m WHERE m.favorite = :favorite")})
public class MostViews implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MostViewsPK mostViewsPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "view")
    private int view;
    @Basic(optional = false)
    @NotNull
    @Column(name = "favorite")
    private boolean favorite;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public MostViews() {
    }

    public MostViews(MostViewsPK mostViewsPK) {
        this.mostViewsPK = mostViewsPK;
    }

    public MostViews(MostViewsPK mostViewsPK, int view, boolean favorite) {
        this.mostViewsPK = mostViewsPK;
        this.view = view;
        this.favorite = favorite;
    }

    public MostViews(int customerId, int programId) {
        this.mostViewsPK = new MostViewsPK(customerId, programId);
    }

    public MostViewsPK getMostViewsPK() {
        return mostViewsPK;
    }

    public void setMostViewsPK(MostViewsPK mostViewsPK) {
        this.mostViewsPK = mostViewsPK;
    }

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    public boolean getFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mostViewsPK != null ? mostViewsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MostViews)) {
            return false;
        }
        MostViews other = (MostViews) object;
        if ((this.mostViewsPK == null && other.mostViewsPK != null) || (this.mostViewsPK != null && !this.mostViewsPK.equals(other.mostViewsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.MostViews[ mostViewsPK=" + mostViewsPK + " ]";
    }
    
}
