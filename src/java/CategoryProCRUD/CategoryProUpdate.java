/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategoryProCRUD;

import CategoryProfile.CategoryProfiles;
import CategoryProfile.CategoryProfilesDAOImpl;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import CategoryProfile.CategoryProfilesDAO;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Firoz Saifi
 */
@WebServlet(urlPatterns = {"/CategoryProUpdate"})
@MultipartConfig(maxFileSize = 10*1024*1024,maxRequestSize = 20*1024*1024,fileSizeThreshold = 5*1024*1024)
public class CategoryProUpdate extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        
        CategoryProfilesDAO pdao=new CategoryProfilesDAOImpl();
        CategoryProfiles p=new CategoryProfiles();
        
        
                        p.setSpecialization(req.getParameter("CategoryName"));
                   
                        p.setDescription(req.getParameter("CategoryDescription"));
                        
                        p.setId(Integer.parseInt(req.getParameter("id")));
        
        
        
        
        if(req.getPart("CategoryPhoto").getInputStream().available() !=0)
        {
         //start image upload
        Part cp = req.getPart("CategoryPhoto");
        
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
        
        p.setImage(imageurl);
        
        //end
        }
        else
        {
            p.setImage("");
        }
        

       
        pdao.update(p);
        resp.sendRedirect("CategoryProView.jsp");
        
        
        
        
        
        
        
        
       
    }
    
    
    
}

