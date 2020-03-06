/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Custom
 */
@Entity
@Table(name = "pay_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PayDetail.findAll", query = "SELECT p FROM PayDetail p")
    , @NamedQuery(name = "PayDetail.findById", query = "SELECT p FROM PayDetail p WHERE p.id = :id")
    , @NamedQuery(name = "PayDetail.findByIdBill", query = "SELECT p FROM PayDetail p WHERE p.idBill = :idBill")
    , @NamedQuery(name = "PayDetail.findByDate", query = "SELECT p FROM PayDetail p WHERE p.date = :date")
    , @NamedQuery(name = "PayDetail.findByAmount", query = "SELECT p FROM PayDetail p WHERE p.amount = :amount")
    , @NamedQuery(name = "PayDetail.findByNote", query = "SELECT p FROM PayDetail p WHERE p.note = :note")
    , @NamedQuery(name = "PayDetail.findByPaymentMethod", query = "SELECT p FROM PayDetail p WHERE p.paymentMethod = :paymentMethod")
    , @NamedQuery(name = "PayDetail.getByDate", query = "SELECT p FROM PayDetail p WHERE p.date >= :startDate AND p.date <= :endDate")})
public class PayDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private float amount;
    @Size(max = 1000)
    @Column(name = "note")
    private String note;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "payment_method")
    private String paymentMethod;
    @JoinColumn(name = "id_bill", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bill idBill;

    public PayDetail() {
    }

    public PayDetail(Integer id) {
        this.id = id;
    }

    public PayDetail(Integer id, Date date, int amount, String paymentMethod) {
        this.id = id;
        this.date = date;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Bill getIdBill() {
        return idBill;
    }

    public void setIdBill(Bill idBill) {
        this.idBill = idBill;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PayDetail)) {
            return false;
        }
        PayDetail other = (PayDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nguyentienthuat.entity.PayDetail[ id=" + id + " ]";
    }
    
}
