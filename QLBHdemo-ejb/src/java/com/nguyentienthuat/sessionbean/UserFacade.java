/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Custom
 */
@Stateless
public class UserFacade extends AbstractFacade<User> implements UserFacadeLocal {

    @PersistenceContext(unitName = "QLBHdemo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    @Override
    public int count() {
        return super.count(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(User entity) {
        super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(User entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(User entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    public UserFacade() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        Query query = em.createNamedQuery("User.findByUsername");
        query.setParameter("username", username);
        return (User) query.getSingleResult();
    }
    
}
