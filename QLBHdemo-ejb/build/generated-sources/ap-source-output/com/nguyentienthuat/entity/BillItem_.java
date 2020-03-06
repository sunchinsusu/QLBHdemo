package com.nguyentienthuat.entity;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-06T13:58:54")
@StaticMetamodel(BillItem.class)
public class BillItem_ { 

    public static volatile SingularAttribute<BillItem, Float> unitPrice;
    public static volatile SingularAttribute<BillItem, Integer> quantity;
    public static volatile SingularAttribute<BillItem, Product> idProduct;
    public static volatile SingularAttribute<BillItem, Integer> id;
    public static volatile SingularAttribute<BillItem, Bill> idBill;

}