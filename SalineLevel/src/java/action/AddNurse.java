/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

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

/**
 *
 * @author Dinesh
 */
public class AddNurse extends HttpServlet {

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
            PrintWriter out = response.getWriter();
            String fname = request.getParameter("firstName");
            String lname = request.getParameter("lastName");
            String email = request.getParameter("inputEmail");
            String mobile = request.getParameter("mobile");
            String password = request.getParameter("inputPassword");
            String education = request.getParameter("education");
            String joiningdate = request.getParameter("joiningdate");
            String salary = request.getParameter("salary");
            String sql = "SELECT * FROM nurse_details WHERE email='" + email + "'";
            Connection con = Dbconnection.getConn();
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Nurse details already added!');");
                out.println("location='add_nurse.jsp';");
                out.println("</script>");
            } else {
                String name = fname + " " + lname;
                sql = "INSERT INTO nurse_details VALUES(0,'" + name + "','" + email + "','" + password + "','" + mobile + "','" + education + "','" + joiningdate + "','" + salary + "','Not Assigned','Active')";
                int row_affected = st.executeUpdate(sql);
                if (row_affected > 0) {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Nurse Details Added Successfully!');");
                    out.println("location='view_nurse.jsp';");
                    out.println("</script>");
                } else {
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('Nurse details not added!');");
                    out.println("location='view_nurse.jsp';");
                    out.println("</script>");
                }

            }
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
