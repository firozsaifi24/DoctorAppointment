/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import DatabaseConnection.DBConnection;
import DoctorProCRUD.LoginTemplate;
import com.sun.faces.action.RequestMapping;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = "/EmailExistValid")
public class EmailExistValid extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        PrintWriter out=resp.getWriter();
        
        
        
        
        String email=req.getParameter("email");  
        System.out.println("remote email: "+email);
        
        
        boolean userResult=userLogin(email);
        
         if(userResult==true)
               {                 
                   System.out.println("User Login Success");
                   out.println("false");
               }
         else 
         {
             
             boolean doctorResult=doctorLogin(email);
             if(doctorResult==true)
             {
                  System.out.println("Doctor Login success");
                  out.println("false");
                 
             }
             else
             {
                System.out.println("Login failed");
                out.println("true");
 
             }
             
         }
        
        
        
        
    }
    
    public boolean userLogin(String email) {
         
        Boolean match=false;
        
        try
           {
               
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select id, name, email, password, role from userdetails";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                  String userEmail=rs.getString("EMAIL");
                  
                  System.out.println("dbemail "+userEmail);
                  
                  System.out.println("user email "+email);
                  
                  if(email.equals(userEmail))
                  {
                      System.out.println("I am in user database");
                      match=true;
                      break;
                  }           
                  
                   
               }                    
               

           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        return match;
        
    }

    public boolean doctorLogin(String email) {
    
        Boolean match=false;
        
        try
        {      
               
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select id, name, email, password, role from doctordetails";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                  String userEmail=rs.getString("EMAIL");
                  
                  System.out.println("doctordbemail "+userEmail);
                  
                  System.out.println("user email "+email);
                  
                  if(email.equals(userEmail))
                  {
                      System.out.println("I am in doctor database");
                      match=true;
                      break;
                  }           
                  
                   
               }                    

            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        return match;
    }
    
    
}
