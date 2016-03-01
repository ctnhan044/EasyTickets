/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.ProgramDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface ProgramDetailsFacadeLocal {

    void create(ProgramDetails programDetails);

    void edit(ProgramDetails programDetails);

    void remove(ProgramDetails programDetails);

    ProgramDetails find(Object id);

    List<ProgramDetails> findAll();

    List<ProgramDetails> findRange(int[] range);

    int count();
    
}
