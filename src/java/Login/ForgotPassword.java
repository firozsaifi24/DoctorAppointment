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
import javax.ejb.EJB;
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
@WebServlet(urlPatterns = "/ForgotPassword")
public class ForgotPassword extends HttpServlet {
      
    private String userName="";
    private String userPassword="";
    private String message="";
    
    @EJB
    private MailSender mailSender;
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        PrintWriter out=resp.getWriter();
        
        
        //user email with subject and message which have to be sent
        String toEmail=req.getParameter("EmailReset");
        String subject="Password Recovery";
        message="";
        
        //my account details
        String fromEmail="ffiroj07@gmail.com";
        String username="ffiroj07";
        String password="9650626765";
        
        System.out.println("remote email: "+toEmail);
        
              
        boolean userResult=userLogin(toEmail);
        
         if(userResult==true)
               {                 
                   System.out.println("User Login Success");
                   mailSender.sendEmail(fromEmail, username, password, toEmail, subject, message);
                   if(mailSender.somethingWrong.equals("NOTCONNECT"))
                   {
                    RequestDispatcher rd = req.getRequestDispatcher("successResetNotConnect.jsp");
                    rd.forward(req, resp);
                   }
                   else
                   {
                    RequestDispatcher rd = req.getRequestDispatcher("successResetPass.jsp");
                    rd.forward(req, resp);
                    //resp.sendRedirect("successResetPass.jsp");
                   }
                   
               }
         else 
         {
             
             boolean doctorResult=doctorLogin(toEmail);
             if(doctorResult==true)
             {
                  System.out.println("Doctor Login success");
                  mailSender.sendEmail(fromEmail, username, password, toEmail, subject, message);
                  RequestDispatcher rd = req.getRequestDispatcher("successResetPass.jsp");
                  rd.forward(req, resp);
                  //resp.sendRedirect("successResetPass.jsp");
                 
             }
             else
             {
                System.out.println("Login failed");
                req.setAttribute("error", "This Email is not registered with us.");
                RequestDispatcher rd = req.getRequestDispatcher("ForgotPassword.jsp");
                rd.forward(req, resp);
 
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
                      userName=rs.getString("NAME");
                      userPassword=rs.getString("PASSWORD");
                      message="<html><body>Hi "+userName+", <br/> <br/> Your password for the National Hospital is: "+userPassword+"<br/><a href='http://localhost:31066/DoctorAppointment/Login.jsp'>Click here</a> to login. <br/><br/> Regards <br/>National Hospital Team</body></html>";
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
                      userName=rs.getString("NAME");
                      userPassword=rs.getString("PASSWORD");
                      message="<html><body>Hi "+userName+", <br/> <br/> Your password for the National Hospital is: "+userPassword+"<br/><a href='http://localhost:31066/DoctorAppointment/Login.jsp'>Click here</a> to login. <br/><br/> Regards <br/>National Hospital Team</body></html>";
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
