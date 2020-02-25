/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.sessionbean;

import com.nguyentienthuat.entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Custom
 */
@Stateless
public class ProductFacade extends AbstractFacade<Product> implements ProductFacadeLocal {

    @PersistenceContext(unitName = "QLBHdemo-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProductFacade() {
        super(Product.class);
    }

    @Override
    public int count() {
        return super.count(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findRange(int[] range) {
        return super.findRange(range); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product find(Object id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Product entity) {
        super.remove(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Product entity) {
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void create(Product entity) {
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product FindById(Integer id) {
        Query query = em.createNamedQuery("Product.findById");
        query.setParameter("id", id);
        return (Product) query.getSingleResult();
    }
    
}
