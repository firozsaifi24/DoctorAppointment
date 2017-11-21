/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Firoz Saifi
 */
public class DBConnection {
    private Connection conn;
    private static DBConnection l=new DBConnection();
    
    public static DBConnection getInstance(){
            return l;
        }
    public Connection getDBCon()
    {
        return this.conn;
    }
    private DBConnection()
    {
        try
        {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            this.conn=DriverManager.getConnection("jdbc:derby://localhost:1527/DoctorsAppoint","root","root");
            if(conn!=null)
            {
                System.out.println("Database Connected");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
                
    }

}
