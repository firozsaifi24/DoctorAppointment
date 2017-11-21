/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoctorProfile;

import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public interface DoctorProfilesDAO {
    
    void insert(DoctorProfiles dp);
    void update(DoctorProfiles dp);
    void delete(int dpid);
    
    DoctorProfiles getProfiles(int dpid);
    List<DoctorProfiles> getProfiles();
    
        //Doctor timing
    void insertTime(DoctorProfiles dp);
    
        //Doctor category wise
    List<DoctorProfiles> fetchDoctors(String category);
    
}
