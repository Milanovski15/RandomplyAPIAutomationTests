package RandomlyApiTests;

import checks.RandomlyChecks;
import helpermodels.PostHelperModel;
import helpermodels.SignUpHelperModel;
import io.restassured.response.Response;
import model.response.*;
import org.junit.Before;
import org.junit.Test;
import service.RandomlyService;
import static org.junit.Assert.assertEquals;

public class CommentsTest {
    private RandomlyChecks checks = new RandomlyChecks();
    private PostResponseBodyPOST postResponseBody;
    private Response commentResponse;
    private LoginResponseBodyPOST loginResponseBody;
    private RandomlyService service = new RandomlyService();
    private SignUpHelperModel signupRequestResponse;
    private PostHelperModel postResponse;

    @Before
    public void userSetup(){
        signupRequestResponse = service.signUp();

        loginResponseBody = service.login(
                signupRequestResponse.getSignupRequestBody().getUsername(),
                signupRequestResponse.getSignupRequestBody().getPassword()).as(LoginResponseBodyPOST.class);

        postResponse = service.postPost(loginResponseBody.getToken(), "Symphony solutions Back-end task");
        postResponseBody = postResponse.getPostResponse().body().as(PostResponseBodyPOST.class);
        commentResponse = service.postComment(postResponseBody, "i dont know what to comment", loginResponseBody.getToken());
    }

    @Test
    public void validateAdditionOfACommentTest(){
        assertEquals(201, commentResponse.statusCode());
        checks.initialPostCommentResponseBodyCheck(loginResponseBody, commentResponse);
    }

    @Test
    public void validateCommentsTest(){
        assertEquals(200, service.getComment(postResponseBody.getId(), loginResponseBody.getToken()).statusCode());
        checks.getCommentResponseBodyCheck(loginResponseBody,1,service.getComment(postResponseBody.getId(), loginResponseBody.getToken()));
    }

}
