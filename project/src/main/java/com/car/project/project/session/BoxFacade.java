/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.car.project.project.session;

import com.car.project.project.entity.Box;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dmitriy
 */
@Stateless
public class BoxFacade extends AbstractFacade<Box> {
    @PersistenceContext(unitName = "com.car.project_project_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BoxFacade() {
        super(Box.class);
    }
    
}
