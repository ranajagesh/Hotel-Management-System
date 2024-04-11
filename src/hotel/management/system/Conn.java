package hotel.management.system;

import java.sql.*;

public class Conn {
   
    Connection c ;
    Statement s;
    Conn() {
        try {
            //Register The Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
            //Create Connection
        c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem","root","Jagesh@2501");
            // Creating Statement
        s = c.createStatement();
            // Executing MySQL queries
        
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
}
