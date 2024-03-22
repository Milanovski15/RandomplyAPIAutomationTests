package RandomlyApiTests;

import checks.RandomlyChecks;
import helpermodels.SignUpHelperModel;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import service.RandomlyService;
import static org.junit.Assert.assertEquals;


public class LoginUserTests {

    private RandomlyChecks checks;
    private RandomlyService service = new RandomlyService();
    private SignUpHelperModel signupRequestResponse;
    private Response loginResponse;

    @Before
    public void createUser(){
        checks = new RandomlyChecks();
        signupRequestResponse = service.signUp();
    }

    @Test
    public void loginWithUserTest(){
        loginResponse = service.login(
                signupRequestResponse.getSignupRequestBody().getUsername(),
                signupRequestResponse.getSignupRequestBody().getPassword());

        assertEquals(200, loginResponse.statusCode());
        checks.initialLoginResponseBodyChecks(signupRequestResponse.getSignupRequestBody(), loginResponse);
    }

}
