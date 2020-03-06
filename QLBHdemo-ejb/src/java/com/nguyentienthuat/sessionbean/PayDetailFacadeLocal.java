/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.PayDetail;
import java.util.Date;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Custom
 */
@Local
public interface PayDetailFacadeLocal {

    void create(PayDetail payDetail);

    void edit(PayDetail payDetail);

    void remove(PayDetail payDetail);

    PayDetail find(Object id);

    List<PayDetail> findAll();

    List<PayDetail> findRange(int[] range);

    int count();

    List<PayDetail> findByIdBill(int idBill);

    List<PayDetail> getByDate(String startDateStr, String endDateStr);
    
}
