/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Bill;
import java.util.Date;
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
    public Bill findById(int id) {
        Query query = em.createNamedQuery("Bill.findById");
        query.setParameter("id", id);
        return (Bill) query.getSingleResult();
    }

    @Override
    public int save(Bill bill) {
        em.persist(bill);
        em.flush();
        return bill.getId();
    }

    @Override
    public void edit(Bill entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Bill> getByDate(Date startDate, Date endDate) {
        return null;
    }
    
}
