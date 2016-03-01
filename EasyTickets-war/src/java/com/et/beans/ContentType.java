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
@Table(name = "Content_Type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContentType.findAll", query = "SELECT c FROM ContentType c"),
    @NamedQuery(name = "ContentType.findByTypeId", query = "SELECT c FROM ContentType c WHERE c.typeId = :typeId"),
    @NamedQuery(name = "ContentType.findByTypeName", query = "SELECT c FROM ContentType c WHERE c.typeName = :typeName")})
public class ContentType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "type_id")
    private Integer typeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "type_name")
    private String typeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeId")
    private Collection<SiteContent> siteContentCollection;

    public ContentType() {
    }

    public ContentType(Integer typeId) {
        this.typeId = typeId;
    }

    public ContentType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlTransient
    public Collection<SiteContent> getSiteContentCollection() {
        return siteContentCollection;
    }

    public void setSiteContentCollection(Collection<SiteContent> siteContentCollection) {
        this.siteContentCollection = siteContentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentType)) {
            return false;
        }
        ContentType other = (ContentType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.ContentType[ typeId=" + typeId + " ]";
    }
    
}
