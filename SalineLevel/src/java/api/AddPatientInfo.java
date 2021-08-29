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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import pack.Dbconnection;

/**
 *
 * @author Dinesh
 */
public class AddPatientInfo extends HttpServlet {

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
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String mobile = request.getParameter("mobile");
            String address = request.getParameter("address");
            String description = request.getParameter("description");
            String nurse_id = request.getParameter("nurse_id");
            String bed_number = request.getParameter("bed_number");
            Connection con = Dbconnection.getConn();
            Statement st = con.createStatement();
            Statement st1 = con.createStatement();
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            Date date = new Date();
            JSONObject json = new JSONObject();
            String timeStamp = format.format(date);
            ResultSet rs = st.executeQuery("SELECT * FROM patient_details WHERE patient_name='" + name + "'");
            if (rs.next()) {
                String id = rs.getString("patient_id");
                String sql = "SELECT * FROM admitted_details WHERE patient_id='" + id + "' and status='Admitted'";
                ResultSet rs1 = st1.executeQuery(sql);
                if (rs1.next()) {
                    json.put("success", "true");
                    json.put("message", "Patient Already admitted");
                } else {

                    sql = "insert into admitted_details values(0,'" + id + "','" + nurse_id + "','" + bed_number + "','" + timeStamp + "','NA','"+description+"','0','Admitted')";
                    int row_affected = st1.executeUpdate(sql);
                    if (row_affected > 0) {
                        json.put("success", "true");
                        json.put("message", "Patient admitted successfully..");
                    } else {
                        json.put("success", "true");
                        json.put("message", "There is problem..");
                    }
                }
            } else {

                String sql = "INSERT INTO patient_details VALUES(0,'" + name + "','" + email + "','" + mobile + "','" + address + "','" + timeStamp + "','Active')";
                int row_affected = st.executeUpdate(sql);
                if (row_affected > 0) {
                    sql = "SELECT * FROM patient_details WHERE patient_email='" + email + "'";
                    rs.close();
                    rs = st.executeQuery(sql);
                    if (rs.next()) {
                        String id = rs.getString("patient_id");
                        sql = "insert into admitted_details values(0,'" + id + "','" + nurse_id + "','" + bed_number + "','" + timeStamp + "','NA','"+description+"','0','Admitted')";

                         row_affected = st1.executeUpdate(sql);
                        if (row_affected > 0) {
                            json.put("success", "true");
                            json.put("message", "Patient admitted successfully..");
                        } else {
                            json.put("success", "true");
                            json.put("message", "There is problem..");
                        }
                    }

                } else {
                    json.put("success", "true");
                    json.put("message", "There is problem..");
                }
            }
            con.close();
            response.setContentType("application/json");
            response.getWriter().write(json.toString());
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
