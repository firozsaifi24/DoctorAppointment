/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Feedback;

import FeedbackProfile.FeedbackProfilesDAO;
import FeedbackProfile.FeedbackProfilesDAOImpl;
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
@WebServlet(urlPatterns = "/FeedbackDelete")
public class FeedbackDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
        int id= Integer.parseInt(req.getParameter("id"));
        
        FeedbackProfilesDAO fpdao=new FeedbackProfilesDAOImpl();
        
        fpdao.delete(id);
        
        resp.sendRedirect("success.jsp");
    }
    
    
}
