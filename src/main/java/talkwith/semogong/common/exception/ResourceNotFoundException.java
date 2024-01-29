package talkwith.semogong.common.exception;

import talkwith.semogong.common.enums.ExceptionInfo;

public class ResourceNotFoundException extends BusinessException {
    public ResourceNotFoundException(ExceptionInfo exceptionInfo, String message) {
        super(exceptionInfo, message);
    }
}
