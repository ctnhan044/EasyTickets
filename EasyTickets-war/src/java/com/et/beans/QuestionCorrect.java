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
@Table(name = "Question_Correct")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionCorrect.findAll", query = "SELECT q FROM QuestionCorrect q"),
    @NamedQuery(name = "QuestionCorrect.findById", query = "SELECT q FROM QuestionCorrect q WHERE q.id = :id")})
public class QuestionCorrect implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "question_id", referencedColumnName = "quesstion_id")
    @ManyToOne(optional = false)
    private QuestionsList questionId;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne(optional = false)
    private Customer customerId;

    public QuestionCorrect() {
    }

    public QuestionCorrect(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public QuestionsList getQuestionId() {
        return questionId;
    }

    public void setQuestionId(QuestionsList questionId) {
        this.questionId = questionId;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionCorrect)) {
            return false;
        }
        QuestionCorrect other = (QuestionCorrect) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.QuestionCorrect[ id=" + id + " ]";
    }
    
}
