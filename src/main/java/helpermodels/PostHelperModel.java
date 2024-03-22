package helpermodels;

import io.restassured.response.Response;
import lombok.Data;
import model.request.PostRequestBodyPOST;

@Data
public class PostHelperModel {

    PostRequestBodyPOST postRequestBody;
    Response postResponse;

    public PostHelperModel(PostRequestBodyPOST postRequestBody){
        this.postRequestBody = postRequestBody;
    }


}
