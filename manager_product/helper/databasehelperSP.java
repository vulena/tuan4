/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.poly.manager_product.helper;
import edu.poly.manager_product.model.product;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LÊNA
 */
public class databasehelperSP {
    public static Connection opConnection() {
        final String Url = "jdbc:sqlserver://DESKTOP-MU64O7N\\SQLEXPRESS:1433;databaseName=Manager_Product";
        final String user = "sa";
        final String pass = "12345";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(Url, user, pass);
        }  catch (ClassNotFoundException | SQLException e) {
        }
      return null;
    }
    public static void main(String[] args) {
        Connection connection = opConnection();
       if (connection !=  null){
           System.out.println("GOOD");
           
       }
       else 
            System.out.println("FAIL");
    }
}
