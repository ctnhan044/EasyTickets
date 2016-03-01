/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.ContentType;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface ContentTypeFacadeLocal {

    void create(ContentType contentType);

    void edit(ContentType contentType);

    void remove(ContentType contentType);

    ContentType find(Object id);

    List<ContentType> findAll();

    List<ContentType> findRange(int[] range);

    int count();
    
}
