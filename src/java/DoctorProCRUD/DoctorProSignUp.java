/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorProCRUD;

import DoctorProfile.DoctorProfiles;
import DoctorProfile.DoctorProfilesDAO;
import DoctorProfile.DoctorProfilesDAOImpl;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = "/DoctorProSignUp")
@MultipartConfig(maxFileSize = 10*1024*1024,maxRequestSize = 20*1024*1024,fileSizeThreshold = 5*1024*1024)
public class DoctorProSignUp extends HttpServlet {

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
        
        DoctorProfilesDAO dpdao=new DoctorProfilesDAOImpl();
        DoctorProfiles dp=new DoctorProfiles();
       
        /*
        ArrayList <String> al=new ArrayList<>();
        
        Enumeration e = request.getParameterNames();
        
      
      
        while(e.hasMoreElements())
        {
        Object obj = e.nextElement();
        String fieldName = (String) obj;
        String fieldValue = request.getParameter(fieldName);
        al.add(fieldValue);      
        }
        */
                        dp.setName(request.getParameter("DoctorName"));
                   
                        dp.setEmail(request.getParameter("DoctorEmail"));
         
                        dp.setPassword(request.getParameter("DoctorPassword"));

                        

                        dp.setConfirmpassword(request.getParameter("DoctorConfirmPassword"));

                        

                        dp.setGender(request.getParameter("DoctorGender"));

                        

                        dp.setDateofbirth(request.getParameter("DoctorDOB"));

                        dp.setSpecialization(request.getParameter("DoctorSpecialist"));

                        dp.setExperience(request.getParameter("DoctorExperience"));

                        dp.setPhone(request.getParameter("DoctorPhone"));

                        dp.setAddress(request.getParameter("DoctorAddress"));
                        
                        
                        
                 
                        //start image upload
            Part cp = request.getPart("DoctorPhoto");
        
            byte b[] = new byte[ cp.getInputStream().available() ];

            cp.getInputStream().read(b);
        
            System.out.println( this.getServletContext().getRealPath("/") );
   
            File f = new File( this.getServletContext().getRealPath("/") + "/image.jpg" );
        
            FileOutputStream fos = new FileOutputStream(f);
        
            fos.write(b);
        
            fos.close();
        
            //end
        
             //start upload image on cloud
        
            Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "firoz",
                "api_key", "669958381375318",
                "api_secret", "yMJGDLuK1z0ykpW7Fi2g1LkuDrE"));
        
            Map uploadResult = cloudinary.uploader().upload(f, ObjectUtils.emptyMap());
        
            System.out.println( uploadResult.get("secure_url") );
        
            String imageurl=(String)uploadResult.get("secure_url");
        
            System.out.println("imagetoDB "+imageurl);
        
        //end
        
            dp.setPhoto(imageurl);
        
            
         //insert in database
        dpdao.insert(dp);
        response.sendRedirect("success.jsp");
                        
       
        /*
        
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements())
        {
        Object obj = e.nextElement();
        String fieldName = (String) obj;
        String fieldValue = request.getParameter(fieldName);
        switch(fieldName)
        {
            case "DoctorName":
                        dp.setName(fieldValue);
                        break;
                        
                    case "DoctorEmail":
                        dp.setEmail(fieldValue);
                        break;
                        
                    case "DoctorPassword":
                        dp.setPassword(fieldValue);
                        break;
                        
                    case "DoctorConfirmPassword":
                        dp.setConfirmpassword(fieldValue);
                        break;
                        
                    case "DoctorGender":
                        dp.setGender(fieldValue);
                        break;
                        
                    case "DoctorDOB":
                        dp.setDateofbirth(fieldValue);
                        break;
                        
                    case "DoctorSpecialist":
                        dp.setSpecialization(fieldValue);
                        break;
                        
                    case "DoctorExperience":
                        dp.setExperience(fieldValue);
                        break;
                        
                    case "DoctorPhone":
                        dp.setPhone(fieldValue);
                        break;
                        
                    case "DoctorAddress":
                        dp.setAddress(fieldValue);
                        break;  
                 
            
        }
        System.out.println(fieldName + " : " + fieldValue );
        }
        
        
        dpdao.insert(dp);
        response.sendRedirect("success.jsp");
        */
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
