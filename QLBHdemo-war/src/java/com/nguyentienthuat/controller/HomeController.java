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
import com.nguyentienthuat.sessionbean.CustomerFacadeLocal;
import com.nguyentienthuat.sessionbean.ProductFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class HomeController extends HttpServlet {

    @EJB
    private BillFacadeLocal billFacade;

    @EJB
    private CustomerFacadeLocal customerFacade;

    @EJB
    private ProductFacadeLocal productFacade;

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
        if(action.equals("Product Manager")){
            ArrayList<Product> products = new ArrayList<>(productFacade.findAll());
            request.setAttribute("products", products);
            request.getRequestDispatcher("/product.jsp").forward(request, response);
        }
        else if(action.equals("Customer Manager")){
            ArrayList<Customer> customers = new ArrayList<>(customerFacade.findAll());
            request.setAttribute("customers", customers);
            request.getRequestDispatcher("/customer.jsp").forward(request, response);
        }
        else if(action.equals("Bill Manager")){
            ArrayList<Product> products = new ArrayList<>(productFacade.findAll());
            request.setAttribute("products", products);
            
            ArrayList<Customer> customers = new ArrayList<>(customerFacade.findAll());
            request.setAttribute("customers", customers);
            
            ArrayList<Bill> bills = new ArrayList<>(billFacade.findAll());
            request.setAttribute("bills", bills);
            
            request.getRequestDispatcher("/bill.jsp").forward(request, response);
        }
        else if(action.equals("Logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
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
