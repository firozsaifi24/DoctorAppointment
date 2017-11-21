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
@WebServlet(urlPatterns = "/AppointmentDateTimeExist")
public class AppointmentDateTimeExist extends HttpServlet {
        
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        PrintWriter out=resp.getWriter();
        
        
        
        String doctor=req.getParameter("doctor");
        String date=req.getParameter("date");  
        String time=req.getParameter("time");
        System.out.println("remote date time: "+date+" "+time);
        
        
        boolean userResult=existDateTime(doctor,date,time);
        
         if(userResult==true)
               {                 
                   System.out.println("User Login Success");
                   out.println("false");
               }
         else 
         {
             
                out.println("true");
 
             
         }
        
        
        
        
    }
    
    public boolean existDateTime(String doctor, String date, String time) {
         
        Boolean match=false;
        
        try
           {
               
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select doctorname, availabletime, date, time from appointments";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                  String userDoctor=rs.getString("DOCTORNAME");
                  String userDate=rs.getString("DATE");
                  String userTime=rs.getString("TIME");
                  
                  System.out.println("db date time "+userDoctor+" "+userDate+" "+userTime);
                  
                  System.out.println("user date time "+doctor+" "+date+" "+time);
                  
                  if(doctor.equals(userDoctor) && date.equals(userDate) && time.equals(userTime))
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
    
    
    
}
