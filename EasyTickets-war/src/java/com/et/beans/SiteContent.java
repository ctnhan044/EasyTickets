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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Nhan Chau KP
 */
@Entity
@Table(name = "Site_Content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SiteContent.findAll", query = "SELECT s FROM SiteContent s"),
    @NamedQuery(name = "SiteContent.findByContentId", query = "SELECT s FROM SiteContent s WHERE s.contentId = :contentId"),
    @NamedQuery(name = "SiteContent.findByTitle", query = "SELECT s FROM SiteContent s WHERE s.title = :title")})
public class SiteContent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "content_id")
    private Integer contentId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "content")
    private String content;
    @JoinColumn(name = "type_id", referencedColumnName = "type_id")
    @ManyToOne(optional = false)
    private ContentType typeId;

    public SiteContent() {
    }

    public SiteContent(Integer contentId) {
        this.contentId = contentId;
    }

    public SiteContent(Integer contentId, String title, String content) {
        this.contentId = contentId;
        this.title = title;
        this.content = content;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
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

    public ContentType getTypeId() {
        return typeId;
    }

    public void setTypeId(ContentType typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contentId != null ? contentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SiteContent)) {
            return false;
        }
        SiteContent other = (SiteContent) object;
        if ((this.contentId == null && other.contentId != null) || (this.contentId != null && !this.contentId.equals(other.contentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.SiteContent[ contentId=" + contentId + " ]";
    }
    
}
