/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Appointment;

import AppointmentProfile.AppointProfilesDAO;
import AppointmentProfile.AppointProfilesDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = "/DeleteAppoint")
public class DeleteAppoint extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id= Integer.parseInt(req.getParameter("id"));
        
        AppointProfilesDAO apdao=new AppointProfilesDAOImpl();
        
        apdao.delete(id);
        
        resp.sendRedirect("AppointmentView.jsp");
    }
    
}
