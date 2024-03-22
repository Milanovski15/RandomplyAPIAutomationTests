package client;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.request.CommentRequestBodyPOST;
import model.request.LoginRequestBodyPOST;
import model.request.PostRequestBodyPOST;
import model.request.SignUpRequestBodyPOST;
import util.Config;

public class RandomlyClient {

    public Response postSignUp(SignUpRequestBodyPOST request){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Config.RANDOMLY_SIGN_UP_POST)
                .thenReturn();
    }

    public Response postLogin(LoginRequestBodyPOST request){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .post(Config.RANDOMLY_LOGIN_POST)
                .thenReturn();
    }

    public Response postPost(PostRequestBodyPOST request, String token){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .header("Authorization", "token " + token)
                .post(Config.RANDOMLY_POST_POST)
                .thenReturn();
    }

    public Response postComment(CommentRequestBodyPOST request, String token){
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .when().log().all()
                .body(request)
                .header("Authorization", "token " + token)
                .post(Config.RANDOMLY_COMMENT_POST)
                .thenReturn();
    }

    public Response getComment(int id, String token){
        return RestAssured
                .given()
                .when().log().all()
                .header("Authorization", "token " + token)
                .pathParam("id", id)
                .get(Config.RANDOMLY_COMMENT_GET)
                .thenReturn();
    }
}
