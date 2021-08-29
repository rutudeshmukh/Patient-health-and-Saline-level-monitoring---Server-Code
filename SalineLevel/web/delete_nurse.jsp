<%-- 
    Document   : delete_ward
    Created on : Mar 7, 2019, 11:14:17 AM
    Author     : Dinesh
--%>

<%@page import="java.sql.Statement"%>
<%@page import="pack.Dbconnection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    String nurse_id = request.getParameter("id");
    Connection con = Dbconnection.getConn();
    Statement st = con.createStatement();

    String sql = "DELETE FROM nurse_details WHERE nurse_id=" + nurse_id + "";
    int row_affected = st.executeUpdate(sql);
    if (row_affected > 0) {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('Nurse Detials Deleted!');");
        out.println("location='view_nurse.jsp';");
        out.println("</script>");
    } else {
        out.println("<script type=\"text/javascript\">");
        out.println("alert('There is problem!');");
        out.println("location='view_nurse.jsp';");
        out.println("</script>");
    }

%>
