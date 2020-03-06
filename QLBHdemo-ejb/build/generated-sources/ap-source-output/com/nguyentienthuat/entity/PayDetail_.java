package com.nguyentienthuat.entity;

import com.nguyentienthuat.entity.Bill;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-03-06T13:58:54")
@StaticMetamodel(PayDetail.class)
public class PayDetail_ { 

    public static volatile SingularAttribute<PayDetail, Date> date;
    public static volatile SingularAttribute<PayDetail, String> note;
    public static volatile SingularAttribute<PayDetail, Float> amount;
    public static volatile SingularAttribute<PayDetail, String> paymentMethod;
    public static volatile SingularAttribute<PayDetail, Integer> id;
    public static volatile SingularAttribute<PayDetail, Bill> idBill;

}