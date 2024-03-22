package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentResponseBodyGET {

    int count;
    String next;
    String previous;
    List<Result> results;
}
