
package Bank.Management.System;

import java.sql.*;

public class Conn {
    Statement statement ;
    PreparedStatement pstatement ;
    Connection connection ;
    public Conn(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           connection =  DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/banksystem",
                    "root",
                    "");

            System.out.println("Database Connected Successfully!");
            statement = connection.createStatement();

        } catch (ClassNotFoundException | SQLException e) {
        }
    }
    public static void main(String[] args) {
        Conn conn = new Conn();
    }
}
