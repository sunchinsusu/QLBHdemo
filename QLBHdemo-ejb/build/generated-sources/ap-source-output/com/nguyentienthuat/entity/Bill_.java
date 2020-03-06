package com.nguyentienthuat.entity;

import com.nguyentienthuat.entity.BillItem;
import com.nguyentienthuat.entity.Customer;
import com.nguyentienthuat.entity.PayDetail;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-06T08:35:32")
@StaticMetamodel(Bill.class)
public class Bill_ { 

    public static volatile SingularAttribute<Bill, Date> date;
    public static volatile ListAttribute<Bill, PayDetail> payDetailList;
    public static volatile ListAttribute<Bill, BillItem> billItemList;
    public static volatile SingularAttribute<Bill, Integer> id;
    public static volatile SingularAttribute<Bill, String> status;
    public static volatile SingularAttribute<Bill, Customer> idCustomer;

}