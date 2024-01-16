package talkwith.semogong.feature.join.exception;

import lombok.Getter;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.common.exception.BusinessException;

@Getter
public class DuplicateNameException extends BusinessException {

    public DuplicateNameException(ExceptionInfo exceptionInfo, String message) {
        super(exceptionInfo, message);
    }
}
