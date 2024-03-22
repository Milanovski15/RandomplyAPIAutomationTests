package model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostRequestBodyPOST {

    String text;
    String image;

}
