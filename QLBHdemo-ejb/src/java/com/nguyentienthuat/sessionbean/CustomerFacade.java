/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Customer;
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
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeLocal {

    @PersistenceContext(unitName = "QLBHdemo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CustomerFacade() {
        super(Customer.class);
    }

    @Override
    public int count() {
        return super.count(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findRange(int[] range) {
        return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Customer> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Customer entity) {
        super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Customer entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Customer entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer findById(Integer id) {
        Query query = em.createNamedQuery("Customer.findById");
        query.setParameter("id", id);
        return (Customer) query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        em.persist(customer);
        em.flush();
    }

    
}
