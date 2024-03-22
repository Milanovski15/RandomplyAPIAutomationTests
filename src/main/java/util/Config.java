package util;

public class Config {
    public static final String RANDOMLY_BASE_URL = "https://randomlyapi.symphony.is/api/";
    public static final String RANDOMLY_SIGN_UP_POST = RANDOMLY_BASE_URL + "auth/signup/";
    public static final String RANDOMLY_LOGIN_POST = RANDOMLY_BASE_URL + "auth/login/";
    public static final String RANDOMLY_POST_POST = RANDOMLY_BASE_URL + "posts/";
    public static final String RANDOMLY_COMMENT_POST = RANDOMLY_BASE_URL + "post-comments/";
    public static final String RANDOMLY_COMMENT_GET = RANDOMLY_BASE_URL + "posts/{id}/comments/";
}
