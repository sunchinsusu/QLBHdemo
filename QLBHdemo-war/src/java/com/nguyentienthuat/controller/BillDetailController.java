    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nguyentienthuat.controller;

import com.nguyentienthuat.connection.DAO;
import com.nguyentienthuat.entity.Bill;
import com.nguyentienthuat.entity.BillDetail;
import com.nguyentienthuat.sessionbean.BillDetailFacadeLocal;
import com.nguyentienthuat.sessionbean.BillFacadeLocal;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author Custom
 */
public class BillDetailController extends HttpServlet {

    @EJB
    private BillDetailFacadeLocal billDetailFacade;

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
            throws ServletException, IOException, ClassNotFoundException, SQLException{
        String action = request.getParameter("action");
        if(action.equals("Delete")){
            String idBillStr = request.getParameter("id");
            int idBill = Integer.parseInt(idBillStr);
            Bill bill = billFacade.findById(idBill);
            ArrayList<BillDetail> billDetails = new ArrayList<>(bill.getBillDetailList());
            for(BillDetail bd : billDetails){
                billDetailFacade.remove(bd);
            }
            billFacade.remove(bill);
            response.sendRedirect("./HomeController?action=Bill Manager");
        }
        else if(action.equals("PrintReport")){
            String idBillStr = request.getParameter("id");
            int idBill = Integer.parseInt(idBillStr);
            Map<String, Object> parameters = new HashMap<String, Object>();  
            parameters.put("idBill", idBill);
            try {
                Connection con = DAO.getConnection();
                JasperReport jr = JasperCompileManager.compileReport("C:/Users/Custom/Documents/EJB/QLBHdemo/QLBHdemo-war/src/java/com/nguyentienthuat/report/BillReport.jrxml");
                JasperPrint jp = JasperFillManager.fillReport(jr, parameters,con);
                JasperFillManager.fillReport(jr, parameters);
                String urlResult = "C:/Users/Custom/Documents/EJB/QLBHdemoReport/BillReport"+idBillStr+".pdf";
                JasperExportManager.exportReportToPdfFile(jp, urlResult);
            } catch (JRException ex) {
                Logger.getLogger(BillDetailController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            response.sendRedirect("./HomeController?action=Bill Manager");
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(BillDetailController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(BillDetailController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
