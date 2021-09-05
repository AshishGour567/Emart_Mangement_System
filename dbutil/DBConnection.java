/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emart.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ashis
 */
public class DBConnection {
    public static Connection con = null; 
    static
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@//Ashish:1521/xe","grocery","admin");
            JOptionPane.showMessageDialog(null,"Connection Done Successfully!","Success!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(ClassNotFoundException e){
           JOptionPane.showMessageDialog(null,"Driver Error!","Error!",JOptionPane.ERROR_MESSAGE);
           e.printStackTrace();
           System.exit(1);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Connection Error!","Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
            System.exit(1);
        }
    }
    public static Connection getConnection()
    {
        return con;
    }  
    public  static void CloseConnection()
    {
        try{
            con.close(); 
             JOptionPane.showMessageDialog(null,"Connection closed Successfully!","Success!",JOptionPane.INFORMATION_MESSAGE);
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error in close the connection!","Error!",JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
