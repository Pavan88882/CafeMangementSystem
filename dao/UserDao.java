/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import model.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author pavan
 */
public class UserDao {

    public static void save(user user) {
        String query = "insert into user(name,email,mobileNumber,address, password,securityQuestion,answer,status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        dbOperations.setDataorDelete(query, "registered Successfully! wait for admin approval");
    }

    public static user login(String email, String password) {
        user user1 = null;
        try {
            ResultSet rs = dbOperations.getData("select *from user where email='" + email + "' and password='" + password + "'");
            while (rs.next()) {
                user1 = new user();
                user1.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user1;
    }

    public static user getSecurityQuestion(String email) {
        user user1 = null;
        try {
            ResultSet rs = dbOperations.getData("select *from user where email= '" + email + "'");
            while (rs.next()) {
                user1 = new user();
                user1.setSecurityQuestion(rs.getString("securityQuestion"));
                user1.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user1;
    }

    public static void update(String email, String newPassword) {
        String query = "Update user set Password = '" + newPassword + "'where email='" + email + "'";
        dbOperations.setDataorDelete(query, "Password changed Successfully");
    }

    public static ArrayList<user> getAllRecords(String email) {
        ArrayList<user> arrayList = new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("Select * from user where email like '%" + email + "%'");
            while (rs.next()) {
                user user1 = new user();
                user1.setId(rs.getInt("id"));
                user1.setName(rs.getString("name"));
                user1.setEmail(rs.getString("email"));
                user1.setMobileNumber(rs.getString("MobileNumber"));
                user1.setAddress(rs.getString("address"));
                user1.setSecurityQuestion(rs.getString("securityQuestion"));
                user1.setStatus(rs.getString("status"));
                arrayList.add(user1);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return arrayList;

    }
    public static void changeStatus(String email, String status){
        String query = "Update user set status ='"+status+"' where email ='"+email+"'";
        dbOperations.setDataorDelete(query, "status changed successfully");
        
    }
    public static void changePassword(String email,String oldPassword,String newPassword){
        try {
            ResultSet rs = dbOperations.getData("Select *from user where email ='"+email+"' and password ='"+oldPassword+"'");
            if(rs.next()){
                update(email,newPassword);
            }
            else{
                JOptionPane.showMessageDialog(null, "Old Password is Wrong");
                
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    public static void changeSecurityQuestion(String email,String password,String securityQuestion, String answer){
        try {
            ResultSet rs = dbOperations.getData("select *from user where email ='"+email+"' and password='"+password+"'");
            if(rs.next()){
                update(email,securityQuestion,answer);
            }
            else{
                JOptionPane.showMessageDialog(null, "Password is wrong");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void update(String email,String securityQuestion,String answer) {
        String query = "update user set securityQuestion='"+securityQuestion+"',answer ='"+answer+"' where email = '"+email+"'";
        dbOperations.setDataorDelete(query, "Security Question Changed Successfully");
    }
        
    
}
