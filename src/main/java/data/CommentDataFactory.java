package data;

import model.request.CommentRequestBodyPOST;

public class CommentDataFactory {

    private CommentRequestBodyPOST request;

    public CommentDataFactory(CommentRequestBodyPOST request){
        this.request = request;
    }

    public CommentDataFactory setText(String value){
        request.setText(value);
        return this;
    }

    public CommentDataFactory setPost(int value){
        request.setPost(value);
        return this;
    }

    public CommentRequestBodyPOST createRequest(){
        return request;
    }
}
