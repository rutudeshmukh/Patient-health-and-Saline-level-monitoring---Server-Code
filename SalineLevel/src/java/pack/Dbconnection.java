/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Phoenixzone
 */
public class Dbconnection {
    
    public static Connection getConn()throws Exception{
         Class.forName("com.mysql.jdbc.Driver");
         Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/saline_level","root","root");
        return con;
    
    }
   
}
