package service;

import client.RandomlyClient;
import data.CommentDataFactory;
import data.PostDataFactory;
import data.SignUpDataFactory;

import helpermodels.PostHelperModel;
import helpermodels.SignUpHelperModel;
import io.restassured.response.Response;
import model.request.CommentRequestBodyPOST;
import model.request.LoginRequestBodyPOST;
import model.response.PostResponseBodyPOST;


import static util.ObjectBuilder.*;

public class RandomlyService {

    public SignUpHelperModel signUp(){
        SignUpHelperModel model = new SignUpHelperModel(new SignUpDataFactory(createBodyForSignUp())
                .createRequest());

        Response signupResponse = new RandomlyClient()
                .postSignUp(model.getSignupRequestBody());

        model.setSignUpResponse(signupResponse);

        return model;
    }

    public Response login(String username, String password){
        LoginRequestBodyPOST loginRequestBody = new LoginRequestBodyPOST(username, password);

        return new RandomlyClient()
                .postLogin(loginRequestBody);
    }

    public PostHelperModel postPost(String token, String text){
        PostHelperModel postHelperModel = new PostHelperModel(new PostDataFactory(createPost())
                .setText(text)
                .createRequest());

        Response postResponse = new RandomlyClient()
                .postPost(postHelperModel.getPostRequestBody(), token);

        postHelperModel.setPostResponse(postResponse);

        return postHelperModel;
    }

    public Response postComment(PostResponseBodyPOST responseBodyPOST, String text, String token){
        //CommentHelperModel commentHelperModel = new CommentHelperModel();

        CommentRequestBodyPOST commentRequestBody = new CommentDataFactory(createComment())
                .setText(text)
                .setPost(responseBodyPOST.getId())
                .createRequest();

         return new RandomlyClient()
                .postComment(commentRequestBody, token);
    }

    public Response getComment(int id, String token){
        return new RandomlyClient()
                .getComment(id, token);
    }

}
