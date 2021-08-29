/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pack.Dbconnection;
import pack.JavaCode;

/**
 *
 * @author Dinesh
 */
public class UpdateSaline extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try {
            /* TODO output your page here. You may use following sample code. */
            int level = Integer.parseInt(request.getParameter("field1"));
            String sql = "SELECT * FROM admitted_details WHERE patient_id='1'";
            Connection con = Dbconnection.getConn();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Statement st1 = con.createStatement();

            if (rs.next()) {
                sql = "SELECT * FROM nurse_details WHERE nurse_id='" + rs.getString("nurse_id") + "'";
                ResultSet rs1 = st1.executeQuery(sql);
                if (rs1.next()) {
                    String mobile = rs1.getString("mobile");
                    String message = "Saline level is at medium level. Patient_id is 1.";
                     JavaCode javacode=new JavaCode();
                    if (level >8 && level < 13) {
                        javacode.sendMessage(mobile, message);
                    } else if (level > 12) {
                         javacode.sendMessage(mobile, "Saline level at critical level. Be Alert. Patient_id is 1.");
                    }
                }
            }
        } catch (Exception e) {
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
