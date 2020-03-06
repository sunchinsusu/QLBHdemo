/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.controller;

import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.BillItem;
import com.nguyentienthuat.entity.PayDetail;
import com.nguyentienthuat.sessionbean.BillFacadeLocal;
import com.nguyentienthuat.sessionbean.BillItemFacadeLocal;
import com.nguyentienthuat.sessionbean.PayDetailFacadeLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Custom
 */
public class PaymentController extends HttpServlet {

    @EJB
    private BillItemFacadeLocal billItemFacade;

    @EJB
    private PayDetailFacadeLocal payDetailFacade;

    @EJB
    private BillFacadeLocal billFacade;

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
        if(action.equals("Pay")){
            float amount = Float.parseFloat(request.getParameter("amount"));
            
            int idBill = Integer.parseInt(request.getParameter("id"));
            Bill bill = billFacade.findById(idBill);
            
            float totalPaid = 0;
            ArrayList<PayDetail> payDetails = new ArrayList<>(payDetailFacade.findByIdBill(idBill));
            for(PayDetail pd : payDetails){
                totalPaid += pd.getAmount();
            }
            
            float totalBill = 0;
            ArrayList<BillItem> billItems = new ArrayList<>(billItemFacade.findByIdBill(idBill));
            for(BillItem bi : billItems){
                totalBill += bi.getQuantity()*bi.getUnitPrice();
            }
            
            if((amount+totalPaid)>totalBill){
                response.sendRedirect("./BillDetailController?action=Pay&id="+idBill+"&mes=Error! Amount invalid.");
            }
            else{
                if((amount+totalPaid)==totalBill){
                    bill.setStatus("Paid off");
                    billFacade.edit(bill);
                }
                else{
                    bill.setStatus("Not even paid off yet");
                    billFacade.edit(bill);
                }
                
                String method = request.getParameter("paymentMethod");
            
                String note = request.getParameter("note");

                Date date = Calendar.getInstance().getTime();

                PayDetail pd = new PayDetail();
                pd.setAmount(amount);
                pd.setNote(note);
                pd.setPaymentMethod(method);
                pd.setIdBill(bill);
                pd.setDate(date);
                payDetailFacade.create(pd);

                response.sendRedirect("./BillDetailController?action=Pay&id="+idBill);
            }
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
