package talkwith.semogong.feature.search.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NotExistsUserByName extends Exception{
    private String message;
    public NotExistsUserByName(String message) {
        this.message = message;
    }
}
