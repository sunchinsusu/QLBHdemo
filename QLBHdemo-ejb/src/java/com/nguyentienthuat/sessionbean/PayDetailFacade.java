/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.PayDetail;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class PayDetailFacade extends AbstractFacade<PayDetail> implements PayDetailFacadeLocal {

    @EJB
    private BillFacadeLocal billFacade;

    @PersistenceContext(unitName = "QLBHdemo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PayDetailFacade() {
        super(PayDetail.class);
    }

    @Override
    public List<PayDetail> findByIdBill(int idBill) {
        Bill bill = billFacade.findById(idBill);
        Query query = em.createNamedQuery("PayDetail.findByIdBill");
        query.setParameter("idBill", bill);
        return query.getResultList();
    }
    
    @Override
    public List<PayDetail> getByDate(String startDateStr, String endDateStr) {
        Query query = em.createNamedQuery("PayDetail.getByDate");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = format.parse(startDateStr);
            endDate = format.parse(endDateStr);
        } catch (ParseException ex) {
            Logger.getLogger(PayDetailFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }
    
}
