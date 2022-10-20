/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import javax.swing.JOptionPane;
import java.io.*;

/**
 *
 * @author pavan
 */
public class OpenPdf {
    public static void openById(String id ){
        try {
            if((new File("C:\\"+id+".pdf")).exists()){
                Process p = Runtime
                        .getRuntime()
                        .exec("rund1132 url.dll,FileProtocolHandler C:\\"+id+".pdf");
            }
            else{
                JOptionPane.showMessageDialog(null, "File is not found");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
