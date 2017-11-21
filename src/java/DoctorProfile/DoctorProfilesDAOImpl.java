/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorProfile;

import DatabaseConnection.DBConnection;
import UserProfile.UserProfiles;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public class DoctorProfilesDAOImpl implements DoctorProfilesDAO {

    @Override
    public void insert(DoctorProfiles dp) {
           try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="insert into doctordetails(name, email, password, confirmpassword, gender, dateofbirth, specialization, experience, phone, address, photo) values (?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, dp.getName());
               ps.setString(2, dp.getEmail());
               ps.setString(3, dp.getPassword());
               ps.setString(4, dp.getConfirmpassword());
               ps.setString(5, dp.getGender());
               ps.setString(6, dp.getDateofbirth());
               ps.setString(7, dp.getSpecialization());
               ps.setString(8, dp.getExperience());
               ps.setString(9, dp.getPhone());
               ps.setString(10, dp.getAddress());
               ps.setString(11, dp.getPhoto());
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public void update(DoctorProfiles dp) {
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon();
               String query;
               if(dp.getPhoto().equals(""))
               {
                    query="update doctordetails set name=?, email=?, password=?, confirmpassword=?, gender=?, dateofbirth=?, specialization=?, experience=?, phone=?, address=? where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, dp.getName());
               ps.setString(2, dp.getEmail());
               ps.setString(3, dp.getPassword());
               ps.setString(4, dp.getConfirmpassword());
               ps.setString(5, dp.getGender());
               ps.setString(6, dp.getDateofbirth());
               ps.setString(7, dp.getSpecialization());
               ps.setString(8, dp.getExperience());
               ps.setString(9, dp.getPhone());
               ps.setString(10, dp.getAddress());
               ps.setInt(11,dp.getId());
               
               ps.executeUpdate();
               }
               else
               {
                    query="update doctordetails set name=?, email=?, password=?, confirmpassword=?, gender=?, dateofbirth=?, specialization=?, experience=?, phone=?, address=?, photo=? where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, dp.getName());
               ps.setString(2, dp.getEmail());
               ps.setString(3, dp.getPassword());
               ps.setString(4, dp.getConfirmpassword());
               ps.setString(5, dp.getGender());
               ps.setString(6, dp.getDateofbirth());
               ps.setString(7, dp.getSpecialization());
               ps.setString(8, dp.getExperience());
               ps.setString(9, dp.getPhone());
               ps.setString(10, dp.getAddress());
               ps.setString(11, dp.getPhoto());
               ps.setInt(12,dp.getId());
               
               ps.executeUpdate();
               }
              
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public void delete(int dpid) {
            
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="delete from doctordetails where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setInt(1, dpid);
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public DoctorProfiles getProfiles(int dpid) {
        DoctorProfiles dp=new DoctorProfiles();
        
                 try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from doctordetails where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setInt(1,dpid);
                             
               ResultSet rs=ps.executeQuery();
               
               rs.next();
               
                   dp.setId(rs.getInt("ID"));
                   dp.setName(rs.getString("NAME"));
                   dp.setEmail(rs.getString("EMAIL"));
                   dp.setPassword(rs.getString("PASSWORD"));
                   dp.setConfirmpassword(rs.getString("CONFIRMPASSWORD"));
                   dp.setGender(rs.getString("GENDER"));
                   dp.setDateofbirth(rs.getString("DATEOFBIRTH"));
                   dp.setSpecialization(rs.getString("SPECIALIZATION"));
                   dp.setExperience(rs.getString("EXPERIENCE"));
                   dp.setPhone(rs.getString("PHONE"));
                   dp.setAddress(rs.getString("ADDRESS"));
                   dp.setStarttime(rs.getString("STARTTIME"));
                   dp.setEndtime(rs.getString("ENDTIME"));
                   dp.setPhoto(rs.getString("PHOTO"));
                   
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }    
        
        
        return dp;
    }

    @Override
    public List<DoctorProfiles> getProfiles() {
        List<DoctorProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from doctordetails order by name";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   DoctorProfiles dp=new DoctorProfiles();
                   dp.setId(rs.getInt("ID"));
                   dp.setName(rs.getString("NAME"));
                   dp.setEmail(rs.getString("EMAIL"));
                   dp.setPassword(rs.getString("PASSWORD"));
                   dp.setConfirmpassword(rs.getString("CONFIRMPASSWORD"));
                   dp.setGender(rs.getString("GENDER"));
                   dp.setDateofbirth(rs.getString("DATEOFBIRTH"));
                   dp.setSpecialization(rs.getString("SPECIALIZATION"));
                   dp.setExperience(rs.getString("EXPERIENCE"));
                   dp.setPhone(rs.getString("PHONE"));
                   dp.setAddress(rs.getString("ADDRESS"));
                   dp.setStarttime(rs.getString("STARTTIME"));
                   dp.setEndtime(rs.getString("ENDTIME"));
                   dp.setPhoto(rs.getString("PHOTO"));
                   
                   list.add(dp);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
    }

    @Override
    public void insertTime(DoctorProfiles dp) {
     try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="update doctordetails set starttime=?, endtime=? where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, dp.getStarttime());
               ps.setString(2, dp.getEndtime());
               ps.setInt(3,dp.getId());
               
               ps.executeUpdate();
               System.out.println("I am in db");
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
    }

    @Override
    public List<DoctorProfiles> fetchDoctors(String category) {
    
         List<DoctorProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from doctordetails where specialization=? order by name";
               PreparedStatement ps=conn.prepareStatement(query);
               ps.setString(1, category);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   DoctorProfiles dp=new DoctorProfiles();
                   dp.setId(rs.getInt("ID"));
                   dp.setName(rs.getString("NAME"));
                   dp.setEmail(rs.getString("EMAIL"));
                   dp.setPassword(rs.getString("PASSWORD"));
                   dp.setConfirmpassword(rs.getString("CONFIRMPASSWORD"));
                   dp.setGender(rs.getString("GENDER"));
                   dp.setDateofbirth(rs.getString("DATEOFBIRTH"));
                   dp.setSpecialization(rs.getString("SPECIALIZATION"));
                   dp.setExperience(rs.getString("EXPERIENCE"));
                   dp.setPhone(rs.getString("PHONE"));
                   dp.setAddress(rs.getString("ADDRESS"));
                   dp.setStarttime(rs.getString("STARTTIME"));
                   dp.setEndtime(rs.getString("ENDTIME"));
                   dp.setPhoto(rs.getString("PHOTO"));
                   
                   list.add(dp);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
        
    }

   


    
}
