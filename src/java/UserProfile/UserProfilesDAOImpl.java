/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;

import UserProfile.*;
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
public class UserProfilesDAOImpl implements UserProfilesDAO {

    @Override
    public void insert(UserProfiles up) {
           try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="insert into userdetails(name, email, password, confirmpassword, gender, dateofbirth, phone, address) values (?,?,?,?,?,?,?,?)";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, up.getName());
               ps.setString(2, up.getEmail());
               ps.setString(3, up.getPassword());
               ps.setString(4, up.getConfirmpassword());
               ps.setString(5, up.getGender());
               ps.setString(6, up.getDateofbirth());
               ps.setString(7, up.getPhone());
               ps.setString(8, up.getAddress());
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public void update(UserProfiles up) {
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="update userdetails set name=?, email=?, password=?, confirmpassword=?, gender=?, dateofbirth=?, phone=?, address=? where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, up.getName());
               ps.setString(2, up.getEmail());
               ps.setString(3, up.getPassword());
               ps.setString(4, up.getConfirmpassword());
               ps.setString(5, up.getGender());
               ps.setString(6, up.getDateofbirth());
               ps.setString(7, up.getPhone());
               ps.setString(8, up.getAddress());
               ps.setInt(9,up.getId());
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public void delete(int upid) {
            
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="delete from userdetails where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setInt(1, upid);
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public UserProfiles getProfiles(int upid) {
        UserProfiles up=new UserProfiles();
        
                 try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from userdetails where id=?";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setInt(1,upid);
                             
               ResultSet rs=ps.executeQuery();
               
               rs.next();
               
                   up.setId(rs.getInt("ID"));
                   up.setName(rs.getString("NAME"));
                   up.setEmail(rs.getString("EMAIL"));
                   up.setPassword(rs.getString("PASSWORD"));
                   up.setConfirmpassword(rs.getString("CONFIRMPASSWORD"));
                   up.setGender(rs.getString("GENDER"));
                   up.setDateofbirth(rs.getString("DATEOFBIRTH"));
                   up.setPhone(rs.getString("PHONE"));
                   up.setAddress(rs.getString("ADDRESS"));
                   
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }    
        
        
        return up;
    }

    @Override
    public List<UserProfiles> getProfiles() {
        List<UserProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from userdetails order by name";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   UserProfiles up=new UserProfiles();
                   up.setId(rs.getInt("ID"));
                   up.setName(rs.getString("NAME"));
                   up.setEmail(rs.getString("EMAIL"));
                   up.setPassword(rs.getString("PASSWORD"));
                   up.setConfirmpassword(rs.getString("CONFIRMPASSWORD"));
                   up.setGender(rs.getString("GENDER"));
                   up.setDateofbirth(rs.getString("DATEOFBIRTH"));
                   up.setPhone(rs.getString("PHONE"));
                   up.setAddress(rs.getString("ADDRESS"));
                   
                   list.add(up);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
    }
    

    
}
