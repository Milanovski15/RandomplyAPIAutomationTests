package RandomlyApiTests;

import checks.RandomlyChecks;
import helpermodels.PostHelperModel;
import helpermodels.SignUpHelperModel;
import model.response.LoginResponseBodyPOST;
import org.junit.Before;
import org.junit.Test;
import service.RandomlyService;

public class PostsTests {
    RandomlyChecks randomlyChecks = new RandomlyChecks();
    LoginResponseBodyPOST loginResponseBody;
    RandomlyService service = new RandomlyService();
    SignUpHelperModel signupRequestResponse;
    PostHelperModel postResponse;

    @Before
    public void userSetup(){
        signupRequestResponse = service.signUp();
        loginResponseBody = service.login(
                signupRequestResponse.getSignupRequestBody().getUsername(),
                signupRequestResponse.getSignupRequestBody().getPassword()).as(LoginResponseBodyPOST.class);
    }

    @Test
    public void userAddsPostTest(){
        postResponse = service.postPost(loginResponseBody.getToken(), "Symphony solutions Back-end task completion");
        randomlyChecks.initialPostResponseBodyCheck(
                signupRequestResponse.getSignupRequestBody(),
                postResponse.getPostRequestBody(),
                postResponse.getPostResponse());
    }
}
