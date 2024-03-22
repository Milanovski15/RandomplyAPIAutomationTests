package RandomlyApiTests;

import checks.RandomlyChecks;
import helpermodels.SignUpHelperModel;
import org.junit.Test;
import service.RandomlyService;

import static org.junit.Assert.assertEquals;

public class SignUpUserTest {

    RandomlyChecks checks = new RandomlyChecks();
    RandomlyService service = new RandomlyService();
    SignUpHelperModel signupRequestResponse;

    @Test
    public void signUpResponseValidationTest(){
        signupRequestResponse = service.signUp();

        assertEquals(201, signupRequestResponse.getSignUpResponse().statusCode());
        checks.signupResponseBodyChecks(signupRequestResponse.getSignUpResponse());
    }

}
