/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author patce
 */
public class DBCon {
    private static Connection con;
    
    public static Connection getConnection() throws Exception
    {
         con = null;
         
        if(con == null)
        {
            String name ="Patience";
            String password = "1234";
            String ur ="jdbc:sqlserver://localhost:1433;databaseName=students";
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(ur, name, password);
            System.out.println("Connected Successfully");
        }
        return con;
    }
    
}
