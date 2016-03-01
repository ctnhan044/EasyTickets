/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.QuestionsList;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface QuestionsListFacadeLocal {

    void create(QuestionsList questionsList);

    void edit(QuestionsList questionsList);

    void remove(QuestionsList questionsList);

    QuestionsList find(Object id);

    List<QuestionsList> findAll();

    List<QuestionsList> findRange(int[] range);

    int count();
    
}
