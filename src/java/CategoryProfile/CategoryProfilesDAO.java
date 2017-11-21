/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CategoryProfile;

import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public interface CategoryProfilesDAO {
    void insert(CategoryProfiles p);
    void update(CategoryProfiles p);
    void delete(int pid);
    
    CategoryProfiles getProfiles(int pid);
    List<CategoryProfiles> getProfiles();
}
