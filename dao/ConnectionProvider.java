/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.*;

/**
 *
 * @author pavan
 */
public class ConnectionProvider {
    public static Connection getCon(){
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?useSSL=false","root","database");
            return con;
        }
        catch(ClassNotFoundException | SQLException e){
            return null;
        }
    }
}
