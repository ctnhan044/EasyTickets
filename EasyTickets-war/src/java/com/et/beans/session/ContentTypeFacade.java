/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.ContentType;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nhan Chau KP
 */
@Stateless
public class ContentTypeFacade extends AbstractFacade<ContentType> implements ContentTypeFacadeLocal {
    @PersistenceContext(unitName = "EasyTickets-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContentTypeFacade() {
        super(ContentType.class);
    }
    
}
