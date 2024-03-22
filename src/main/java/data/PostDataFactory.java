package data;

import model.request.PostRequestBodyPOST;

public class PostDataFactory {

    private PostRequestBodyPOST request;

    public PostDataFactory(PostRequestBodyPOST request){
        this.request = request;
    }

    public PostDataFactory setText(String value){
        request.setText(value);
        return this;
    }

    public PostDataFactory setImage(String value){
        request.setImage(value);
        return this;
    }

    public PostRequestBodyPOST createRequest(){
        return request;
    }

}
