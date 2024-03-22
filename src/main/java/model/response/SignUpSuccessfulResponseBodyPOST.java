package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SignUpSuccessfulResponseBodyPOST {

    String success;
    boolean influencer;
}
