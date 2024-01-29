package talkwith.semogong.common.exception;

import talkwith.semogong.common.enums.ExceptionInfo;

public class AuthenticationFailException extends BusinessException {
    public AuthenticationFailException(ExceptionInfo exceptionInfo, String message) {
        super(exceptionInfo, message);
    }
}
