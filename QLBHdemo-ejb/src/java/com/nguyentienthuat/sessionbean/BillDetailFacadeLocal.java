/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.BillDetail;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Custom
 */
@Local
public interface BillDetailFacadeLocal {

    void create(BillDetail billDetail);

    void edit(BillDetail billDetail);

    void remove(BillDetail billDetail);

    BillDetail find(Object id);

    List<BillDetail> findAll();

    List<BillDetail> findRange(int[] range);

    int count();

    void save(BillDetail billDetail);
    
}
