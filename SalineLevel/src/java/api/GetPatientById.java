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
public class GetPatientById extends HttpServlet {

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
            String bed_number = request.getParameter("bed_number");
            Connection con = Dbconnection.getConn();
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            JSONObject json = new JSONObject();
            JSONArray array = new JSONArray();
            ResultSet rs = st.executeQuery("SELECT * FROM patient_details inner join admitted_details on patient_details.patient_id=admitted_details.patient_id WHERE admitted_details.bed_number='" + bed_number + "'");
            while (rs.next()) {
                JSONObject object = new JSONObject();
                object.put("patient_id",rs.getString("patient_id"));
                object.put("name", rs.getString("patient_name"));
                object.put("mobile", rs.getString("patient_mobile"));
                object.put("email", rs.getString("patient_email"));
                object.put("address", rs.getString("patient_address"));
                object.put("description", rs.getString("description"));
                object.put("bed_number", rs.getString("bed_number"));
                object.put("admitted_on", rs.getString("admitted_on"));
                object.put("saline_level", rs.getString("saline_level"));
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
