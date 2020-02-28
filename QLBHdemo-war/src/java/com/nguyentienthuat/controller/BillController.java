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
import com.nguyentienthuat.sessionbean.BillFacadeLocal;
import com.nguyentienthuat.sessionbean.CustomerFacadeLocal;
import com.nguyentienthuat.sessionbean.ProductFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class BillController extends HttpServlet {

    @EJB
    private ProductFacadeLocal productFacade;

    @EJB
    private BillFacadeLocal billFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

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
        if(action.equals("New bill")){
            HttpSession session = request.getSession();
            
            String idCustomerStr = request.getParameter("idCustomer");
            Customer customer = customerFacade.findById(Integer.parseInt(idCustomerStr));
            session.setAttribute("customer", customer);
            
            ArrayList<BillDetail> cart = (ArrayList<BillDetail>) session.getAttribute("cart");
            if(cart!=null){
                session.removeAttribute("cart");
                session.removeAttribute("total");
            }
            else{
                cart = new ArrayList<>();
                int total = 0;
                session.setAttribute("cart", cart);
                session.setAttribute("total", total);
            }
            
            ArrayList<Product> products = new ArrayList<>( productFacade.findAll());
            request.setAttribute("products", products);
            request.getRequestDispatcher("/cart.jsp").forward(request, response);
        }
        else if(action.equals("View Detail")){
            String idStr = request.getParameter("id");
            Bill bill = billFacade.findById(Integer.parseInt(idStr));
            ArrayList<BillDetail> billDetails = new ArrayList<>(bill.getBillDetailList());
            int total = 0;
            for(BillDetail bd : billDetails){
                total += (bd.getQuantity())*(bd.getIdProduct().getPrice());
            }
            request.setAttribute("total", total);
            request.setAttribute("bill", bill);
            request.setAttribute("billDetails", billDetails);
            request.getRequestDispatcher("/billDetail.jsp").forward(request, response);
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
