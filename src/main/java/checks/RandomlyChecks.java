package checks;

import io.restassured.response.Response;
import model.request.PostRequestBodyPOST;
import model.request.SignUpRequestBodyPOST;
import model.response.*;
import util.DateUtil;

import java.util.List;
import static org.junit.Assert.*;

public class RandomlyChecks {

    DateUtil dtf = new DateUtil();

    public void signupResponseBodyChecks(Response signupResponse){
        SignUpSuccessfulResponseBodyPOST signUpResponseBody = signupResponse.body().as(SignUpSuccessfulResponseBodyPOST.class);
        assertEquals("Thanks for signing up.", signUpResponseBody.getSuccess());
        //assertTrue(signUpResponseBody.isInfluencer());  //ne mi e jasen requirementot koga kje bide true/false zatoa e iskomentiran assertot
    }

    public void initialLoginResponseBodyChecks(SignUpRequestBodyPOST signupRequestBody, Response loginResponse){
        LoginResponseBodyPOST loginResponseBody = loginResponse.body().as(LoginResponseBodyPOST.class);

        assertNotNull(loginResponseBody.getToken());
        assertEquals(signupRequestBody.getUsername(), loginResponseBody.getUser().getUsername());
        assertEquals(signupRequestBody.getFirstName(), loginResponseBody.getUser().getFirstName());
        assertEquals(signupRequestBody.getDateOfBirth(), loginResponseBody.getUser().getDateOfBirth());
        assertEquals(signupRequestBody.getLastName(), loginResponseBody.getUser().getLastName());
        //assertTrue(loginResponseBody.getUser().isInfluencer()); //ne mi e jasen requirementot koga kje bide true/false zatoa e iskomentiran assertot
        //assertTrue(loginResponseBody.getUser().isHasSelectedInfluencers()); //isto i ova
        assertTrue( "Country attribute is not empty", loginResponseBody.getUser().getCountry().isEmpty());
        assertTrue( "City attribute is not empty", loginResponseBody.getUser().getCity().isEmpty());
        assertTrue( "Bio attribute is not empty", loginResponseBody.getUser().getBio().isEmpty());
        assertNull( "Job tittle attribute is not empty", loginResponseBody.getUser().getJobTittle());
        assertEquals(0, loginResponseBody.getUser().getNumberOfFollowers());
        assertEquals(0, loginResponseBody.getUser().getNumberOfFollowings());
        assertNull(loginResponseBody.getUser().getProfileImage());
        assertNull(loginResponseBody.getUser().getCoverImage());
    }

    public void initialPostResponseBodyCheck(SignUpRequestBodyPOST signupRequestBody, PostRequestBodyPOST postRequest, Response postResponse){
        PostResponseBodyPOST postResponseBody = postResponse.body().as(PostResponseBodyPOST.class);

        assertFalse(postResponseBody.isLikedByUser());
        assertEquals(signupRequestBody.getUsername(), postResponseBody.getUser().getUsername());
        assertEquals(signupRequestBody.getFirstName(), postResponseBody.getUser().getFirstName());
        assertEquals(signupRequestBody.getLastName(), postResponseBody.getUser().getLastName());
        assertTrue( "Country attribute is not empty", postResponseBody.getUser().getCountry().isEmpty());
        assertTrue( "City attribute is not empty", postResponseBody.getUser().getCity().isEmpty());
        assertNull( "Job tittle attribute is not empty", postResponseBody.getUser().getJobTittle());
        assertFalse(postResponseBody.getUser().isFollowing());
        assertNull(postResponseBody.getUser().getProfileImage());
        assertNull(postResponseBody.getUser().getCoverImage());
        assertEquals(0, postResponseBody.getLikesCount());
        assertEquals(0, postResponseBody.getCommentsCount());
        assertNull(postResponseBody.getImage());
        assertFalse(postResponseBody.isShare());
        assertNull(postResponseBody.getOriginalPost());
        assertEquals(postRequest.getText(), postResponseBody.getText());
        assertNull(postResponseBody.getUrl());
        assertNull(postResponseBody.getUrlMeta());
        assertEquals(dtf.currentTimeFormatted(), postResponseBody.getCreatedOn());
    }

    public void initialPostCommentResponseBodyCheck(LoginResponseBodyPOST loginResponseBody, Response commentResponse){
        CommentResponseBodyPOST commentResponseBody= commentResponse.body().as(CommentResponseBodyPOST.class);

        assertEquals(loginResponseBody.getUser().getUsername(), commentResponseBody.getUser().getUsername());
        assertEquals(loginResponseBody.getUser().getFirstName(), commentResponseBody.getUser().getFirstName());
        assertEquals(loginResponseBody.getUser().getLastName(), commentResponseBody.getUser().getLastName());
        //assertTrue(loginResponseBody.getUser().isInfluencer()); //ne mi e jasen requirementot koga kje bide true/false zatoa e iskomentiran assertot
        //assertTrue(loginResponseBody.getUser().isHasSelectedInfluencers()); //isto i ova
        assertTrue( "Country attribute is not empty",commentResponseBody.getUser().getCountry().isEmpty());
        assertTrue( "City attribute is not empty", commentResponseBody.getUser().getCity().isEmpty());
        assertNull( "Bio attribute is not empty", commentResponseBody.getUser().getBio());
        assertNull( "Job tittle attribute is not empty", commentResponseBody.getUser().getJobTittle());
        assertEquals(0, commentResponseBody.getUser().getNumberOfFollowers());
        assertEquals(0, commentResponseBody.getUser().getNumberOfFollowings());
        assertNull(commentResponseBody.getUser().getProfileImage());
        assertNull(commentResponseBody.getUser().getCoverImage());
    }

    public void getCommentResponseBodyCheck(LoginResponseBodyPOST loginResponseBody, int count, Response retriveCommentResponse){
        CommentResponseBodyGET retrieveCommentResponseBody = retriveCommentResponse.body().as(CommentResponseBodyGET.class);
        List<Result> resultsList = retrieveCommentResponseBody.getResults();

        assertEquals(count, retrieveCommentResponseBody.getCount());
        for(int i = 0 ; i < resultsList.size() ; i++) {
            assertEquals(loginResponseBody.getUser().getUsername(), retrieveCommentResponseBody.getResults().get(i).getUser().getUsername());
            assertEquals(loginResponseBody.getUser().getFirstName(), retrieveCommentResponseBody.getResults().get(i).getUser().getFirstName());
            assertEquals(loginResponseBody.getUser().getLastName(), retrieveCommentResponseBody.getResults().get(i).getUser().getLastName());
            assertTrue( "Country attribute is not empty",retrieveCommentResponseBody.getResults().get(i).getUser().getCountry().isEmpty());
            assertTrue( "City attribute is not empty", retrieveCommentResponseBody.getResults().get(i).getUser().getCity().isEmpty());
            assertNull( "Job tittle attribute is not empty", retrieveCommentResponseBody.getResults().get(i).getUser().getJobTittle());
            assertFalse(retrieveCommentResponseBody.getResults().get(i).getUser().isFollowing());
            assertNull(retrieveCommentResponseBody.getResults().get(i).getUser().getProfileImage());
            assertNull(retrieveCommentResponseBody.getResults().get(i).getUser().getCoverImage());
            assertEquals(dtf.currentTimeFormatted(), retrieveCommentResponseBody.getResults().get(i).getCreatedOn());
            assertEquals(dtf.currentTimeFormatted(), retrieveCommentResponseBody.getResults().get(i).getCreatedOn());
        }
    }
}
