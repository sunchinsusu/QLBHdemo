/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Bill;
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
public class BillFacade extends AbstractFacade<Bill> implements BillFacadeLocal {

    @PersistenceContext(unitName = "QLBHdemo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillFacade() {
        super(Bill.class);
    }

    @Override
    public int count() {
        return super.count(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bill> findRange(int[] range) {
        return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bill> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Bill entity) {
        super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Bill entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Bill entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bill findById(Integer id) {
        Query query = em.createNamedQuery("Bill.findById");
        query.setParameter("id", id);
        return (Bill) query.getSingleResult();
    }

    @Override
    public Integer save(Bill bill) {
        em.persist(bill);
        em.flush();
        return bill.getId();
    }
    
}
