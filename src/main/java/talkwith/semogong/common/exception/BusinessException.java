package talkwith.semogong.common.exception;

import lombok.Getter;
import talkwith.semogong.common.enums.ExceptionInfo;

@Getter
public class BusinessException extends RuntimeException{
    private final ExceptionInfo exceptionInfo;
    private final String customMessage;

    public BusinessException(ExceptionInfo exceptionInfo, String message) {
        this.exceptionInfo = exceptionInfo;
        this.customMessage = message;
    }
}
