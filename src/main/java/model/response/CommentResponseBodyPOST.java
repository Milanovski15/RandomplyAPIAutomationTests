package model.response;

import lombok.Data;

@Data
public class CommentResponseBodyPOST {

    int id;
    LoginUser user;
    String createdOn;
    String text;

}
