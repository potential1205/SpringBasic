package talkwith.semogong.feature.join.exception;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DuplicateNameException extends Exception{

    private String message;
    public DuplicateNameException(String message) {
        this.message = message;
    }

}
