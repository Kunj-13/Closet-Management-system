/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jpa.entities.Closetuser;

/**
 *
 * @author kxp5571
 */
@Stateless
public class ClosetuserFacade extends AbstractFacade<Closetuser> {

    @PersistenceContext(unitName = "ClosetWebApplicationPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClosetuserFacade() {
        super(Closetuser.class);
    }
    
}
