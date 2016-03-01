/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.RoomStands;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface RoomStandsFacadeLocal {

    void create(RoomStands roomStands);

    void edit(RoomStands roomStands);

    void remove(RoomStands roomStands);

    RoomStands find(Object id);

    List<RoomStands> findAll();

    List<RoomStands> findRange(int[] range);

    int count();
    
}
