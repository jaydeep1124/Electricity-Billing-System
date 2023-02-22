package electricity.billing.system;

import java.sql.*;

public class conn {

    Connection c;
    Statement s;
    conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///ebs", "root", "Jaydeep@2411");
            s = c.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}