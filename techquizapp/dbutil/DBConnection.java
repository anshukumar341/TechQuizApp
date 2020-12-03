/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Aftab
 */
public class DBConnection {
    private static Connection conn;
    static{
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE","onlineexam1","student");
            JOptionPane.showMessageDialog(null, "Connected Successfully To The Database","Success!",JOptionPane.INFORMATION_MESSAGE);
           }
        catch(Exception ex){
        JOptionPane.showMessageDialog(null, "Error Connecting To The Database:"+ex,"Error!",JOptionPane.ERROR_MESSAGE);
        System.out.println("Exception is:"+ex);
        }
    }
    public static Connection getConnection(){
        return conn;
    }

    public static void closeConnection()
    {
        if(conn!=null)
        {
        try {
            
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
    
}
