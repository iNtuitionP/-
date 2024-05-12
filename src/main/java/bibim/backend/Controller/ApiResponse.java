package bibim.backend.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ApiResponse {

    String content;

    public static ApiResponse creat(String content){
        return new ApiResponse(content);
    }
}
