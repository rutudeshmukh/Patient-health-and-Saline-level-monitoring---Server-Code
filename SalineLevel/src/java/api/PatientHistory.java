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
import org.json.JSONArray;
import org.json.JSONObject;
import pack.Dbconnection;

/**
 *
 * @author Dinesh
 */
public class PatientHistory extends HttpServlet {

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
            String patient_id = request.getParameter("id");
            Connection con = Dbconnection.getConn();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM admitted_details inner join nurse_details on admitted_details.nurse_id=nurse_details.nurse_id WHERE admitted_details.patient_id='" + patient_id + "'");
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            while (rs.next()) {
                JSONObject object = new JSONObject();
                object.put("admitted_on", rs.getString("admitted_on"));
                object.put("discharge_on", rs.getString("discharge_on"));
                object.put("description", rs.getString("description"));
                object.put("name", rs.getString("name"));
                object.put("ward_id", rs.getString("ward_id"));
                object.put("bed_number", rs.getString("bed_number"));
                array.put(object);
            }
            json.put("PatientInfo", array);
            json.put("success", "true");
            response.setContentType("application/json");
            response.getWriter().write(json.toString());
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
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
