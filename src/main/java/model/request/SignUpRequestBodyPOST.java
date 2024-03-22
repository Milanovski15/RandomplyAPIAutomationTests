package model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignUpRequestBodyPOST {

    String email;
    String password;
    String firstName;
    String lastName;
    String username;
    String dateOfBirth;

}
