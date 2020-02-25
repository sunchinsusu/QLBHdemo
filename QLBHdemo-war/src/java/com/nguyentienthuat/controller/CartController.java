/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.controller;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.BillDetail;
import com.nguyentienthuat.entity.Customer;
import com.nguyentienthuat.entity.Product;
import com.nguyentienthuat.sessionbean.BillDetailFacadeLocal;
import com.nguyentienthuat.sessionbean.BillFacadeLocal;
import com.nguyentienthuat.sessionbean.ProductFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
    private BillDetailFacadeLocal billDetailFacade;

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
            ArrayList<BillDetail> cart = (ArrayList<BillDetail>) session.getAttribute("cart");
            Customer customer = (Customer) session.getAttribute("customer");
            Bill bill = new Bill();
            
            Calendar cal = Calendar.getInstance();
            Date date = new Date(cal.getTime().getTime());
            
            bill.setIdCustomer(customer);
            bill.setDate(date);
            
            int id = billFacade.save(bill);
            bill.setId(id);
            
            for(BillDetail bd : cart){
                bd.setIdBill(bill);
                billDetailFacade.save(bd);
            }
            
            session.removeAttribute("customer");
            session.removeAttribute("cart");
            
            response.sendRedirect("./HomeController?action=Bill Manager");
        }
        else if(action.equals("Add to Cart")){
            String idProductStr = request.getParameter("idProduct");
            int idProduct = Integer.parseInt(idProductStr);
            String quantityStr = request.getParameter("quantity");
            int quantity = Integer.parseInt(quantityStr);
            
            HttpSession session = request.getSession();
            ArrayList<BillDetail> cart = (ArrayList<BillDetail>) session.getAttribute("cart");
            
            boolean isExist = false;
            
            for(BillDetail bd : cart){
                if(bd.getIdProduct().getId()==idProduct){
                    bd.setQuantity(bd.getQuantity()+quantity);
                    isExist = true;
                    break;
                }
            }
            
            if(isExist==false){
                BillDetail billDetail = new BillDetail(productFacade.FindById(idProduct),quantity);
                cart.add(billDetail);
            }
            
            ArrayList<Product> products = new ArrayList<>( productFacade.findAll());
            request.setAttribute("products", products);
            
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
        else if(action.equals("Remove")){
            String idProductStr = request.getParameter("idProduct");
            int idProduct = Integer.parseInt(idProductStr);
            
            HttpSession session = request.getSession();
            ArrayList<BillDetail> cart = (ArrayList<BillDetail>) session.getAttribute("cart");
            
            for(BillDetail bd : cart){
                if(bd.getIdProduct().getId()==idProduct){
                    cart.remove(bd);
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
