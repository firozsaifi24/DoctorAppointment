/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import DatabaseConnection.DBConnection;
import DoctorProCRUD.LoginTemplate;
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
@WebServlet(urlPatterns = "/Login")
public class Login extends HttpServlet {
    
        
        LoginTemplate lt=new LoginTemplate();
        
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        
        
        
        
        String email=req.getParameter("Email");
        String password=req.getParameter("Password");
        
        /*
        boolean userResult=userLogin(email, password);
        boolean doctorResult=doctorLogin(email, password);

         if(userResult==true)
               {
                   System.out.println("Login Success");
               }
         else if(doctorResult==true)
               {
                   System.out.println("Login Success");
               }
         else
         {
             System.out.println("Login Failed");
         }
        
        */
        
        
        
        boolean userResult=userLogin(email, password);
        
         if(userResult==true)
               {                 
                   System.out.println("Login Success");
                   HttpSession session=req.getSession();  
                   session.setAttribute("loginTemplate",lt);
                   System.out.println("Role in session "+session.getAttribute("loginTemplate"));
                   
                   resp.sendRedirect("index.jsp");
               }
         else 
         {
             
             boolean doctorResult=doctorLogin(email, password);
             if(doctorResult==true)
             {
                  System.out.println("Login success");
                  HttpSession session=req.getSession();  
                  session.setAttribute("loginTemplate",lt);
                  System.out.println("Role in session "+session.getAttribute("loginTemplate")); 
                 
                 resp.sendRedirect("index.jsp");
             }
             else
             {
                System.out.println("Login failed");
                req.setAttribute("error", "invalid Email/Password");
                RequestDispatcher rd = req.getRequestDispatcher("Login.jsp");
                rd.forward(req, resp);
                //resp.sendRedirect("Login.jsp");
 
             }
             
         }
        
        
        
        
    }
    
    public boolean userLogin(String email, String password) {
         
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
                  String userPassword=rs.getString("PASSWORD");
                  
                  System.out.println("dbemail "+userEmail);
                  System.out.println("dbpass "+userPassword);
                  
                  System.out.println("user email "+email);
                  System.out.println("user pass "+password);
                  
                  if(email.equals(userEmail) && password.equals(userPassword))
                  {
                      lt.setId(rs.getInt("ID"));
                      lt.setName(rs.getString("NAME"));
                      lt.setRole(rs.getString("ROLE"));
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

    public boolean doctorLogin(String email, String password) {
    
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
                  String userPassword=rs.getString("PASSWORD");
                  
                  System.out.println("doctordbemail "+userEmail);
                  System.out.println("doctordbpass "+userPassword);
                  
                  System.out.println("user email "+email);
                  System.out.println("user pass "+password);
                  
                  if(email.equals(userEmail) && password.equals(userPassword))
                  {
                      lt.setId(rs.getInt("ID"));
                      lt.setName(rs.getString("NAME"));
                      lt.setRole(rs.getString("ROLE"));
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
