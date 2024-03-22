package model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentRequestBodyPOST {

    String text;
    int post;

}
