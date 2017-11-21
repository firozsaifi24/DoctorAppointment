/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategoryProfile;

import DatabaseConnection.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public class CategoryProfilesDAOImpl implements CategoryProfilesDAO {

    @Override
    public void insert(CategoryProfiles p) {
        try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            String query= "insert into category (specialization,description,image) values (?,?,?)";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,p.getSpecialization());
            ps.setString(2,p.getDescription());
            ps.setString(3,p.getImage());
            
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
    }

    @Override
    public void update(CategoryProfiles p) {
        
         try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            //String query= "update category set specialization=?, description=?, image=? where id=? ";
            String query;
            if(p.getImage().equals(""))
            {
                query= "update category set specialization=?, description=? where id=? ";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,p.getSpecialization());
            ps.setString(2,p.getDescription());
            ps.setInt(3,p.getId());
            ps.executeUpdate();
                
            }
            else
            {
                query= "update category set specialization=?, description=?, image=? where id=? ";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1,p.getSpecialization());
            ps.setString(2,p.getDescription());
            ps.setString(3,p.getImage());
            ps.setInt(4,p.getId());
            ps.executeUpdate();
            }
            
           
            
            
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
        
    }

    @Override
    public void delete(int pid) {
       try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            String query= "delete from category where id=?";
            PreparedStatement ps= conn.prepareStatement(query);
           
            ps.setInt(1,pid);
            
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
    }

    @Override
    public CategoryProfiles getProfiles(int pid) {
        CategoryProfiles p=new CategoryProfiles();
       try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            String query= "select * from category where id=?";
            PreparedStatement ps= conn.prepareStatement(query);
            
            ps.setInt(1, pid);
            ResultSet rs= ps.executeQuery();
                
            rs.next();
             
                p.setId(rs.getInt("ID"));
                p.setSpecialization(rs.getString("SPECIALIZATION"));
                p.setDescription(rs.getString("DESCRIPTION"));
                p.setImage(rs.getString("IMAGE"));
           

                
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
       return p;
    }

    @Override
    public List<CategoryProfiles> getProfiles() {
     List<CategoryProfiles> list=new ArrayList<>();
     
      try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            String query= "select * from category order by specialization";
            PreparedStatement ps= conn.prepareStatement(query);
            
            ResultSet rs= ps.executeQuery();
            while(rs.next())
            {
                CategoryProfiles p=new CategoryProfiles();
                p.setId(rs.getInt("ID"));
                p.setSpecialization(rs.getString("SPECIALIZATION"));
                p.setDescription(rs.getString("DESCRIPTION"));
                p.setImage(rs.getString("IMAGE"));
                
                list.add(p);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
     
     
     return list;
    }
    
}
