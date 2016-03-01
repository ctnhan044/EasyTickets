/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.SiteContent;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface SiteContentFacadeLocal {

    void create(SiteContent siteContent);

    void edit(SiteContent siteContent);

    void remove(SiteContent siteContent);

    SiteContent find(Object id);

    List<SiteContent> findAll();

    List<SiteContent> findRange(int[] range);

    int count();
    
}
