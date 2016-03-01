/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.ShowType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface ShowTypeFacadeLocal {

    void create(ShowType showType);

    void edit(ShowType showType);

    void remove(ShowType showType);

    ShowType find(Object id);

    List<ShowType> findAll();

    List<ShowType> findRange(int[] range);

    int count();
    
}
