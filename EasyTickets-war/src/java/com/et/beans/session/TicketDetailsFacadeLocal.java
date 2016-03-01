/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.beans.session;

import com.et.beans.TicketDetails;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Nhan Chau KP
 */
@Local
public interface TicketDetailsFacadeLocal {

    void create(TicketDetails ticketDetails);

    void edit(TicketDetails ticketDetails);

    void remove(TicketDetails ticketDetails);

    TicketDetails find(Object id);

    List<TicketDetails> findAll();

    List<TicketDetails> findRange(int[] range);

    int count();
    
}
