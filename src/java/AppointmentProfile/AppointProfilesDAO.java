/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppointmentProfile;

import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public interface AppointProfilesDAO {
    
    void insert(AppointProfiles ap);
    void delete(int apid);
    
    List<AppointProfiles> getProfiles();
    
    //user and doctor appointment fetch
    List<AppointProfiles> userProfiles(int userid);
    List<AppointProfiles> doctorProfiles(int doctorid);
    
    
}
