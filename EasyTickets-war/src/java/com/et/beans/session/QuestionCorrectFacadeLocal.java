/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.QuestionCorrect;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface QuestionCorrectFacadeLocal {

    void create(QuestionCorrect questionCorrect);

    void edit(QuestionCorrect questionCorrect);

    void remove(QuestionCorrect questionCorrect);

    QuestionCorrect find(Object id);

    List<QuestionCorrect> findAll();

    List<QuestionCorrect> findRange(int[] range);

    int count();
    
}
