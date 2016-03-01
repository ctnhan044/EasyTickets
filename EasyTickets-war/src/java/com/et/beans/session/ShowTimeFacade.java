/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.ShowTime;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nhan Chau KP
 */
@Stateless
public class ShowTimeFacade extends AbstractFacade<ShowTime> implements ShowTimeFacadeLocal {
    @PersistenceContext(unitName = "EasyTickets-warPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShowTimeFacade() {
        super(ShowTime.class);
    }
    
}
