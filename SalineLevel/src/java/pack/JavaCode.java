/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.Properties;

public class JavaCode {

    String postData = "";
    String retval = "";
    String Username = "richhelps1234";
    String Password = "richhelps1234";
    String MobileNo = "9503986854";
    String Message = "Testing message";
    String SenderID = "PRJCTP";
    String priority = "ndnd";
    String stype = "normal";

    public JavaCode() {
    }

    public void sendMessage(String phone, String message) {
        try {

            this.Message = message;
            this.MobileNo = phone;
            postData += "user=" + Username + "&pass=" + Password + "&phone="
                    + MobileNo + "&sender=" + SenderID + "&text=" + Message + "&priority=" + priority + "&stype=" + stype;
            URL url = new URL("http://bhashsms.com/api/sendmsg.php?");
            HttpURLConnection urlconnection = (HttpURLConnection) url.openConnection();
            urlconnection.setRequestMethod("POST");
            urlconnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlconnection.setDoOutput(true);
            OutputStreamWriter out = new OutputStreamWriter(urlconnection.getOutputStream());
            out.write(postData);
            out.close();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlconnection.getInputStream()));
            String decodedString;
            while ((decodedString = in.readLine()) != null) {
                retval += decodedString;
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JavaCode java = new JavaCode();
        java.sendMessage("9595879440", "Testing message schedulling");
    }

}
