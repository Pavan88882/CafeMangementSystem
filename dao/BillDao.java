/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.ResultSet;
import model.*;
import java.util.ArrayList;

/**
 *
 * @author pavan
 */
public class BillDao {
    public static String getId(){
        int id = 1;
        try{
            ResultSet rs = dbOperations.getData("Select max(id) from bill");
            if(rs.next()){
                id = rs.getInt(1);
                id = id+1;
                
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        return String.valueOf(id);
    }
    public static void save(Bill bill){
        String query="insert into bill values('"+bill.getId()+"','"+bill.getName()+"','"+bill.getMobileNumber()+"','"+bill.getEmail()+"','"+bill.getDate()+"','"+bill.getTotal()+"','"+bill.getCreateBy()+"')";
        dbOperations.setDataorDelete(query, "Bill Details Added Successfully");
        
        
    }
    public static ArrayList<Bill> getAllRecordsByInc(String date){
        ArrayList<Bill> arrayList =new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("select *from bill where date like '%"+date+"%'");
           
            while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setMobileNumber(rs.getString("MobileNumber"));
            bill.setEmail(rs.getString("email"));
            bill.setDate(rs.getString(date));
            bill.setTotal(rs.getString("total"));
            bill.setCreateBy(rs.getString("createdBy"));
            arrayList.add(bill);
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
    public static ArrayList<Bill> getAllRecordsByDesc(String date){
        ArrayList<Bill> arrayList =new ArrayList<>();
        try {
            ResultSet rs = dbOperations.getData("select *from bill where date like '%"+date+"%' order by id DESC");
           
            while(rs.next()){
            Bill bill = new Bill();
            bill.setId(rs.getInt("id"));
            bill.setName(rs.getString("name"));
            bill.setMobileNumber(rs.getString("MobileNumber"));
            bill.setEmail(rs.getString("email"));
            bill.setDate(rs.getString(date));
            bill.setTotal(rs.getString("total"));
            bill.setCreateBy(rs.getString("createdBy"));
            arrayList.add(bill);
            
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
