/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.ShowTime;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface ShowTimeFacadeLocal {

    void create(ShowTime showTime);

    void edit(ShowTime showTime);

    void remove(ShowTime showTime);

    ShowTime find(Object id);

    List<ShowTime> findAll();

    List<ShowTime> findRange(int[] range);

    int count();
    
}
