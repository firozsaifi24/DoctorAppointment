/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import AppointmentProfile.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = "/BookAppoint")
public class BookAppoint extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     
 
        
        AppointProfilesDAO apdao=new AppointProfilesDAOImpl();
        AppointProfiles ap=new AppointProfiles();
        
        
        
                        ap.setName(req.getParameter("UserName"));                       

                        ap.setAge(req.getParameter("UserAge"));
                        
                        ap.setGender(req.getParameter("UserGender"));                      

                        ap.setPhone(req.getParameter("UserPhone"));


                        ap.setSpecialization(req.getParameter("DoctorSpec"));

                        ap.setDoctorname(req.getParameter("DoctorName"));

                        ap.setAvailabletime(req.getParameter("DoctorTime"));                      

                        ap.setDate(req.getParameter("UserDate"));                       

                        ap.setTime(req.getParameter("UserTime"));
                        
                        ap.setUserid(Integer.parseInt(req.getParameter("UserId")));
                        System.out.println("User id: "+ req.getParameter("UserId") + "Doctor Id: "+ req.getParameter("DoctorId"));
                        ap.setDoctorid(Integer.parseInt(req.getParameter("DoctorId")));

            
        
        
         apdao.insert(ap);
         System.out.println("Data inserted");
         resp.sendRedirect("success.jsp");
        
    }
    
}
