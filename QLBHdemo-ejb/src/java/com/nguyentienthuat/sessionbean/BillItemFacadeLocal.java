/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.BillItem;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Custom
 */
@Local
public interface BillItemFacadeLocal {

    void create(BillItem billItem);

    void edit(BillItem billItem);

    void remove(BillItem billItem);

    BillItem find(Object id);

    List<BillItem> findAll();

    List<BillItem> findRange(int[] range);

    int count();

    int save(BillItem billItem);

    List<BillItem> findByIdBill(int idBill);
    
}
