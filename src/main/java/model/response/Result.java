package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Result {

    int id;
    LoginUser user;
    String createdOn;
    String text;
}
