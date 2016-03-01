/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.CAProgram;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface CAProgramFacadeLocal {

    void create(CAProgram cAProgram);

    void edit(CAProgram cAProgram);

    void remove(CAProgram cAProgram);

    CAProgram find(Object id);

    List<CAProgram> findAll();

    List<CAProgram> findRange(int[] range);

    int count();
    
}
