package com.nguyentienthuat.entity;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-28T12:41:54")
@StaticMetamodel(BillDetail.class)
public class BillDetail_ { 

    public static volatile SingularAttribute<BillDetail, Integer> quantity;
    public static volatile SingularAttribute<BillDetail, Product> idProduct;
    public static volatile SingularAttribute<BillDetail, Integer> id;
    public static volatile SingularAttribute<BillDetail, Bill> idBill;

}