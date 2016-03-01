/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.Places;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface PlacesFacadeLocal {

    void create(Places places);

    void edit(Places places);

    void remove(Places places);

    Places find(Object id);

    List<Places> findAll();

    List<Places> findRange(int[] range);

    int count();
    
}
