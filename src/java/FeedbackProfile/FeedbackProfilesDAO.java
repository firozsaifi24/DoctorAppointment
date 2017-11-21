/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FeedbackProfile;

import java.util.List;

/**
 *
 * @author Firoz Saifi
 */
public interface FeedbackProfilesDAO {

    void insert(FeedbackProfiles fp);
    void delete(int fpid);
    List<FeedbackProfiles> getProfiles();
}
