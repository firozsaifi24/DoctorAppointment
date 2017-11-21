/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppointmentProfile;

import CategoryProfile.CategoryProfiles;
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
public class AppointProfilesDAOImpl implements AppointProfilesDAO {

    @Override
    public void insert(AppointProfiles ap) {
      
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="insert into appointments(name, age, gender, phone, specialization, doctorname, availabletime, date, time, userid, doctorid) values (?,?,?,?,?,?,?,?,?,?,?)";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, ap.getName());
               ps.setString(2, ap.getAge());
               ps.setString(3, ap.getGender());
               ps.setString(4, ap.getPhone());
               ps.setString(5, ap.getSpecialization());
               ps.setString(6, ap.getDoctorname());
               ps.setString(7, ap.getAvailabletime());
               ps.setString(8, ap.getDate());
               ps.setString(9, ap.getTime());
               ps.setInt(10, ap.getUserid());
               ps.setInt(11, ap.getDoctorid());
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
    }

    @Override
    public List<AppointProfiles> getProfiles() {
       
         List<AppointProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from appointments";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   AppointProfiles ap=new AppointProfiles();
                   ap.setId(rs.getInt("ID"));
                   ap.setName(rs.getString("NAME"));
                   ap.setAge(rs.getString("AGE"));
                   ap.setGender(rs.getString("GENDER"));
                   ap.setPhone(rs.getString("PHONE"));
                   ap.setSpecialization(rs.getString("SPECIALIZATION"));
                   ap.setDoctorname(rs.getString("DOCTORNAME"));
                   ap.setAvailabletime(rs.getString("AVAILABLETIME"));
                   ap.setDate(rs.getString("DATE"));
                   ap.setTime(rs.getString("TIME"));
                   
                   list.add(ap);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
        
    }

    @Override
    public void delete(int apid) {
        try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            String query= "delete from appointments where id=?";
            PreparedStatement ps= conn.prepareStatement(query);
           
            ps.setInt(1,apid);
            
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
    }

    @Override
    public List<AppointProfiles> userProfiles(int userid) {
       List<AppointProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from appointments where userid=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setInt(1, userid);
               
               
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   AppointProfiles ap=new AppointProfiles();
                   ap.setId(rs.getInt("ID"));
                   ap.setName(rs.getString("NAME"));
                   ap.setAge(rs.getString("AGE"));
                   ap.setGender(rs.getString("GENDER"));
                   ap.setPhone(rs.getString("PHONE"));
                   ap.setSpecialization(rs.getString("SPECIALIZATION"));
                   ap.setDoctorname(rs.getString("DOCTORNAME"));
                   ap.setAvailabletime(rs.getString("AVAILABLETIME"));
                   ap.setDate(rs.getString("DATE"));
                   ap.setTime(rs.getString("TIME"));
                   
                   list.add(ap);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
    }

    @Override
    public List<AppointProfiles> doctorProfiles(int doctorid) {
        List<AppointProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from appointments where doctorid=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setInt(1, doctorid);
               
               
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   AppointProfiles ap=new AppointProfiles();
                   ap.setId(rs.getInt("ID"));
                   ap.setName(rs.getString("NAME"));
                   ap.setAge(rs.getString("AGE"));
                   ap.setGender(rs.getString("GENDER"));
                   ap.setPhone(rs.getString("PHONE"));
                   ap.setSpecialization(rs.getString("SPECIALIZATION"));
                   ap.setDoctorname(rs.getString("DOCTORNAME"));
                   ap.setAvailabletime(rs.getString("AVAILABLETIME"));
                   ap.setDate(rs.getString("DATE"));
                   ap.setTime(rs.getString("TIME"));
                   
                   list.add(ap);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
    }

   
    
}
