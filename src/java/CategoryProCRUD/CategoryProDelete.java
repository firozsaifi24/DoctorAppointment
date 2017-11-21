/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategoryProCRUD;

import CategoryProfile.CategoryProfilesDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CategoryProfile.CategoryProfilesDAO;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = {"/CategoryProDelete"})
public class CategoryProDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id= Integer.parseInt(req.getParameter("id"));
        
        CategoryProfilesDAO pdao= new CategoryProfilesDAOImpl();
        
        pdao.delete(id);
        
        resp.sendRedirect("CategoryProView.jsp");
        
    }
    
    
}
