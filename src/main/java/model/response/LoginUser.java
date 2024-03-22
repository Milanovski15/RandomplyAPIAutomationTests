package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUser {

    int id;
    String username;
    String firstName;
    String dateOfBirth;
    String lastName;
    boolean influencer;
    boolean hasSelectedInfluencers;
    String country;
    String city;
    String bio;
    String jobTittle;
    int numberOfFollowers;
    int numberOfFollowings;
    boolean isFollowing;
    String profileImage;
    String coverImage;

}
