/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.controller;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.BillItem;
import com.nguyentienthuat.entity.Customer;
import com.nguyentienthuat.entity.Product;
import com.nguyentienthuat.sessionbean.BillFacadeLocal;
import com.nguyentienthuat.sessionbean.BillItemFacadeLocal;
import com.nguyentienthuat.sessionbean.ProductFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Custom
 */
public class CartController extends HttpServlet {

    @EJB
    private BillFacadeLocal billFacade;

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private BillItemFacadeLocal billItemFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action.equals("Create Bill")){
            
            HttpSession session = request.getSession();
            ArrayList<BillItem> cart = (ArrayList<BillItem>) session.getAttribute("cart");
            Customer customer = (Customer) session.getAttribute("customer");
            float total = (float) session.getAttribute("total");
            Bill bill = new Bill();
            
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            
            bill.setIdCustomer(customer);
            bill.setDate(date);
            bill.setStatus("Unpaid");
            
            int id = billFacade.save(bill);
            bill.setId(id);
            
            for(BillItem bi : cart){
                bi.setIdBill(bill);
                billItemFacade.save(bi);
            }
            
            session.removeAttribute("customer");
            session.removeAttribute("cart");
            session.removeAttribute("total");
            response.sendRedirect("./HomeController?action=Bill Manager");
        }
        else if(action.equals("Add to Cart")){
            String idProductStr = request.getParameter("idProduct");
            Integer idProduct = Integer.parseInt(idProductStr);
            String quantityStr = request.getParameter("quantity");
            int quantity = Integer.parseInt(quantityStr);
            
            HttpSession session = request.getSession();
            ArrayList<BillItem> cart = (ArrayList<BillItem>) session.getAttribute("cart");
            float total = (float) session.getAttribute("total");
            
            total = total + productFacade.findById(idProduct).getPrice()*quantity;
            
            boolean isExist = false;
            
            for(BillItem bi : cart){
                if(bi.getIdProduct().getId()==idProduct){
                    bi.setQuantity(bi.getQuantity()+quantity);
                    isExist = true;
                    break;
                }
            }
            
            if(isExist==false){
                BillItem billItem = new BillItem();
                Product p = productFacade.findById(idProduct);
                billItem.setIdProduct(p);
                billItem.setQuantity(quantity);
                billItem.setUnitPrice(p.getPrice());
                cart.add(billItem);
            }
            
            ArrayList<Product> products = new ArrayList<>( productFacade.findAll());
            request.setAttribute("products", products);
            
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
        else if(action.equals("Remove")){
            String idProductStr = request.getParameter("idProduct");
            int idProduct = Integer.parseInt(idProductStr);
            
            HttpSession session = request.getSession();
            ArrayList<BillItem> cart = (ArrayList<BillItem>) session.getAttribute("cart");
            float total = (float) session.getAttribute("total");
            
            for(BillItem bi : cart){
                if(bi.getIdProduct().getId()==idProduct){
                    total = total - bi.getIdProduct().getPrice()*bi.getQuantity();
                    cart.remove(bi);
                    break;
                }
            }
            
            ArrayList<Product> products = new ArrayList<>( productFacade.findAll());
            request.setAttribute("products", products);
            
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
