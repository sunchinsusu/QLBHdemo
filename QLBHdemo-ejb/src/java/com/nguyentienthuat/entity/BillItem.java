/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Custom
 */
@Entity
@Table(name = "bill_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BillItem.findAll", query = "SELECT b FROM BillItem b")
    , @NamedQuery(name = "BillItem.findById", query = "SELECT b FROM BillItem b WHERE b.id = :id")
    , @NamedQuery(name = "BillItem.findByIdBill", query = "SELECT b FROM BillItem b WHERE b.idBill = :idBill")    
    , @NamedQuery(name = "BillItem.findByQuantity", query = "SELECT b FROM BillItem b WHERE b.quantity = :quantity")
    , @NamedQuery(name = "BillItem.findByUnitPrice", query = "SELECT b FROM BillItem b WHERE b.unitPrice = :unitPrice")})
public class BillItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "unit_price")
    private float unitPrice;
    @JoinColumn(name = "id_bill", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Bill idBill;
    @JoinColumn(name = "id_product", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product idProduct;

    public BillItem() {
    }

    public BillItem(Integer id) {
        this.id = id;
    }

    public BillItem(Integer id, int quantity, float unitPrice) {
        this.id = id;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Bill getIdBill() {
        return idBill;
    }

    public void setIdBill(Bill idBill) {
        this.idBill = idBill;
    }

    public Product getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Product idProduct) {
        this.idProduct = idProduct;
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
        if (!(object instanceof BillItem)) {
            return false;
        }
        BillItem other = (BillItem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nguyentienthuat.entity.BillItem[ id=" + id + " ]";
    }
    
}
