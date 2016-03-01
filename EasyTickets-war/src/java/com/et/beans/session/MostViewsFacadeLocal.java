/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.MostViews;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface MostViewsFacadeLocal {

    void create(MostViews mostViews);

    void edit(MostViews mostViews);

    void remove(MostViews mostViews);

    MostViews find(Object id);

    List<MostViews> findAll();

    List<MostViews> findRange(int[] range);

    int count();
    
}
