package util;

import model.request.CommentRequestBodyPOST;
import model.request.PostRequestBodyPOST;
import model.request.SignUpRequestBodyPOST;
import org.apache.commons.lang3.RandomStringUtils;
import util.DateUtil;

public class ObjectBuilder {

    public static SignUpRequestBodyPOST createBodyForSignUp(){
        return SignUpRequestBodyPOST.builder()
                .email(RandomStringUtils.randomAlphabetic(10) + "@mail.com")
                .password(RandomStringUtils.randomAlphanumeric(10))
                .firstName(RandomStringUtils.randomAlphabetic(10))
                .lastName(RandomStringUtils.randomAlphabetic(10))
                .username(RandomStringUtils.randomAlphanumeric(10))
                .dateOfBirth(DateUtil.generateRandomDate())
                .build();
    }

    public static PostRequestBodyPOST createPost(){
        return PostRequestBodyPOST.builder()
                .text("Default text")
                .image(null)
                .build();
    }

    public static CommentRequestBodyPOST createComment(){
        return CommentRequestBodyPOST.builder()
                .text("Default text")
                .build();
    }
}
