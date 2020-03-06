/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Bill;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Custom
 */
@Local
public interface BillFacadeLocal {

    void create(Bill bill);

    void edit(Bill bill);

    void remove(Bill bill);

    Bill find(Object id);

    List<Bill> findAll();

    List<Bill> findRange(int[] range);

    int count();

    Bill findById(int id);

    int save(Bill bill);

    List<Bill> getByDate(Date startDate, Date endDate);

    
}
