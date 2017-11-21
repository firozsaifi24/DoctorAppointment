/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProCRUD;

import UserProfile.*;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = "/UserProUpdate")
public class UserProUpdate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        //String updateID=request.getParameter("id");
        
        UserProfilesDAO updao=new UserProfilesDAOImpl();
        UserProfiles up=new UserProfiles();
        

                        up.setName(request.getParameter("UserName"));
                   
                        up.setEmail(request.getParameter("UserEmail"));
         
                        up.setPassword(request.getParameter("UserPassword"));                   

                        up.setConfirmpassword(request.getParameter("UserConfirmPassword"));                      

                        up.setGender(request.getParameter("UserGender"));                       

                        up.setDateofbirth(request.getParameter("UserDOB"));

                        up.setPhone(request.getParameter("UserPhone"));

                        up.setAddress(request.getParameter("UserAddress"));
                        
                        up.setId(Integer.parseInt(request.getParameter("id")));
                       
                         
        
        
       
        updao.update(up);
        response.sendRedirect("success.jsp");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
