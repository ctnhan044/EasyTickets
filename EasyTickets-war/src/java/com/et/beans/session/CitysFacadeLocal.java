/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.Citys;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface CitysFacadeLocal {

    void create(Citys citys);

    void edit(Citys citys);

    void remove(Citys citys);

    Citys find(Object id);

    List<Citys> findAll();

    List<Citys> findRange(int[] range);

    int count();
    
}
