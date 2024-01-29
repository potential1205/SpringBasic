package talkwith.semogong.common.exception;

import talkwith.semogong.common.enums.ExceptionInfo;


public class ResourceConflictException extends BusinessException {

    public ResourceConflictException(ExceptionInfo exceptionInfo, String message) {
        super(exceptionInfo, message);
    }
}
