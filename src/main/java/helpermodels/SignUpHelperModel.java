package helpermodels;

import io.restassured.response.Response;
import lombok.Data;
import model.request.SignUpRequestBodyPOST;

@Data
public class SignUpHelperModel {

    public SignUpHelperModel(SignUpRequestBodyPOST newUserBody){
        this.signupRequestBody = newUserBody ;
    }

    SignUpRequestBodyPOST signupRequestBody;
    Response signUpResponse;
}
