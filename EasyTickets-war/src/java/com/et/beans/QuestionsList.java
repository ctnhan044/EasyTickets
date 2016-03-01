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
@Table(name = "Questions_List")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuestionsList.findAll", query = "SELECT q FROM QuestionsList q"),
    @NamedQuery(name = "QuestionsList.findByQuesstionId", query = "SELECT q FROM QuestionsList q WHERE q.quesstionId = :quesstionId"),
    @NamedQuery(name = "QuestionsList.findByContent", query = "SELECT q FROM QuestionsList q WHERE q.content = :content"),
    @NamedQuery(name = "QuestionsList.findByCorrectAnser", query = "SELECT q FROM QuestionsList q WHERE q.correctAnser = :correctAnser"),
    @NamedQuery(name = "QuestionsList.findByAnswerB", query = "SELECT q FROM QuestionsList q WHERE q.answerB = :answerB"),
    @NamedQuery(name = "QuestionsList.findByAnswerC", query = "SELECT q FROM QuestionsList q WHERE q.answerC = :answerC"),
    @NamedQuery(name = "QuestionsList.findByAnswerD", query = "SELECT q FROM QuestionsList q WHERE q.answerD = :answerD"),
    @NamedQuery(name = "QuestionsList.findByLevel", query = "SELECT q FROM QuestionsList q WHERE q.level = :level")})
public class QuestionsList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "quesstion_id")
    private Integer quesstionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "correct_anser")
    private String correctAnser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "answer_b")
    private String answerB;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "answer_c")
    private String answerC;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "answer_d")
    private String answerD;
    @Basic(optional = false)
    @NotNull
    @Column(name = "level")
    private int level;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "questionId")
    private Collection<QuestionCorrect> questionCorrectCollection;

    public QuestionsList() {
    }

    public QuestionsList(Integer quesstionId) {
        this.quesstionId = quesstionId;
    }

    public QuestionsList(Integer quesstionId, String content, String correctAnser, String answerB, String answerC, String answerD, int level) {
        this.quesstionId = quesstionId;
        this.content = content;
        this.correctAnser = correctAnser;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.level = level;
    }

    public Integer getQuesstionId() {
        return quesstionId;
    }

    public void setQuesstionId(Integer quesstionId) {
        this.quesstionId = quesstionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCorrectAnser() {
        return correctAnser;
    }

    public void setCorrectAnser(String correctAnser) {
        this.correctAnser = correctAnser;
    }

    public String getAnswerB() {
        return answerB;
    }

    public void setAnswerB(String answerB) {
        this.answerB = answerB;
    }

    public String getAnswerC() {
        return answerC;
    }

    public void setAnswerC(String answerC) {
        this.answerC = answerC;
    }

    public String getAnswerD() {
        return answerD;
    }

    public void setAnswerD(String answerD) {
        this.answerD = answerD;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<QuestionCorrect> getQuestionCorrectCollection() {
        return questionCorrectCollection;
    }

    public void setQuestionCorrectCollection(Collection<QuestionCorrect> questionCorrectCollection) {
        this.questionCorrectCollection = questionCorrectCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quesstionId != null ? quesstionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuestionsList)) {
            return false;
        }
        QuestionsList other = (QuestionsList) object;
        if ((this.quesstionId == null && other.quesstionId != null) || (this.quesstionId != null && !this.quesstionId.equals(other.quesstionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.et.beans.QuestionsList[ quesstionId=" + quesstionId + " ]";
    }
    
}
