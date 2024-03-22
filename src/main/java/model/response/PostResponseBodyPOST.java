package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResponseBodyPOST {

    int id;
    boolean isLikedByUser;
    LoginUser user;
    int likesCount;
    int commentsCount;
    String image;
    boolean isShare;
    String originalPost;
    String text;
    String url;
    String urlMeta;
    String createdOn;

}
