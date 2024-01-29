package talkwith.semogong.common.exception;

import talkwith.semogong.common.enums.ExceptionInfo;

public class NotAcceptableException extends BusinessException{
    public NotAcceptableException(ExceptionInfo exceptionInfo, String message) {
        super(exceptionInfo, message);
    }
}
