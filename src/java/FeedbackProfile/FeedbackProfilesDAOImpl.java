/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackProfile;

import AppointmentProfile.AppointProfiles;
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
public class FeedbackProfilesDAOImpl implements FeedbackProfilesDAO {

    @Override
    public void insert(FeedbackProfiles fp) {
      
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="insert into feedback(name, email, comment) values (?,?,?)";
               PreparedStatement ps=conn.prepareStatement(query);
               
               ps.setString(1, fp.getName());
               ps.setString(2, fp.getEmail());
               ps.setString(3, fp.getComment());
               
               ps.executeUpdate();
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
    }

    @Override
    public List<FeedbackProfiles> getProfiles() {
      List<FeedbackProfiles> list=new ArrayList<>();
        
         try
           {
               Connection conn= DBConnection.getInstance().getDBCon(); 
               String query="select * from feedback";
               PreparedStatement ps=conn.prepareStatement(query);
                             
               ResultSet rs=ps.executeQuery();
               
               while(rs.next())
               {
                   FeedbackProfiles fp=new FeedbackProfiles();
                   fp.setId(rs.getInt("ID"));
                   fp.setName(rs.getString("NAME"));
                   fp.setEmail(rs.getString("EMAIL"));
                   fp.setComment(rs.getString("COMMENT"));
                   fp.setFeedbackdate(rs.getString("FEEDBACKDATE"));
                   fp.setFeedbacktime(rs.getString("FEEDBACKTIME"));
                   
                   list.add(fp);
               }
               
           }
           catch(Exception e)
           {
               e.printStackTrace();
           }      
        
        
        return list;
    }

    @Override
    public void delete(int fpid) {
       try
        {
            Connection conn= DBConnection.getInstance().getDBCon(); 
            String query= "delete from feedback where id=?";
            PreparedStatement ps= conn.prepareStatement(query);
           
            ps.setInt(1,fpid);
            
            ps.executeUpdate();
        }
        catch(Exception e)
        {
            e.printStackTrace();           
        }
    }

   

  
}
