/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

import FeedbackProfile.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = "/Feedback")
public class Feedback extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       
        FeedbackProfilesDAO fpdao=new FeedbackProfilesDAOImpl();
        FeedbackProfiles fp=new FeedbackProfiles();


                fp.setName(req.getParameter("CommenterName"));
                fp.setEmail(req.getParameter("CommenterEmail"));
                fp.setComment(req.getParameter("CommenterComment"));
           
                
        fpdao.insert(fp);
        System.out.println("Feedback received");
        resp.sendRedirect("success.jsp");
    }


   
    
}
