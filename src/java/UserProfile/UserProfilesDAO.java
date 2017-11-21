/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserProfile;
import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public interface UserProfilesDAO {
    
    void insert(UserProfiles up);
    void update(UserProfiles up);
    void delete(int upid);
    
    UserProfiles getProfiles(int upid);
    List<UserProfiles> getProfiles();
    
    
}
