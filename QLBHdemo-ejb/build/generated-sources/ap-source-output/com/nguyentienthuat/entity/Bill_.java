package com.nguyentienthuat.entity;

import com.nguyentienthuat.entity.BillDetail;
import com.nguyentienthuat.entity.Customer;
import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-02-28T12:41:54")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Date> date;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile ListAttribute<Bill, BillDetail> billDetailList;
    public static volatile SingularAttribute<Bill, Customer> idCustomer;

}