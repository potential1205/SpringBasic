package talkwith.semogong.feature.join.exception;

import lombok.Getter;
import talkwith.semogong.common.exception.BusinessException;

@Getter
public class DuplicateNameException extends BusinessException {

    public DuplicateNameException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public DuplicateNameException(ErrorCode errorCode) {
        super(errorCode);
    }
}
