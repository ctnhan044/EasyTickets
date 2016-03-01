/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.Program;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface ProgramFacadeLocal {

    void create(Program program);

    void edit(Program program);

    void remove(Program program);

    Program find(Object id);

    List<Program> findAll();

    List<Program> findRange(int[] range);

    int count();
    
}
