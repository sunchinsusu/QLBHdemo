/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.BillItem;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Custom
 */
@Stateless
public class BillItemFacade extends AbstractFacade<BillItem> implements BillItemFacadeLocal {

    @EJB
    private BillFacadeLocal billFacade;

    @PersistenceContext(unitName = "QLBHdemo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BillItemFacade() {
        super(BillItem.class);
    }

    @Override
    public int count() {
        return super.count(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillItem> findRange(int[] range) {
        return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<BillItem> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BillItem find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(BillItem entity) {
        super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(BillItem entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(BillItem entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int save(BillItem billItem) {
        em.persist(billItem);
        em.flush();
        return billItem.getId();
    }

    @Override
    public List<BillItem> findByIdBill(int idBill) {
        Bill bill = billFacade.findById(idBill);
        Query query = em.createNamedQuery("BillItem.findByIdBill");
        query.setParameter("idBill", bill);
        return query.getResultList();
    }
    
}
