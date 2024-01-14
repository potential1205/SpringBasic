package talkwith.semogong.common.exception;

import lombok.Getter;
import talkwith.semogong.feature.join.exception.ErrorCode;

@Getter
public class BusinessException extends RuntimeException{
    private final ErrorCode errorCode;
    private final String customMessage;

    public BusinessException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.customMessage = errorCode.getMessage();
    }

    public BusinessException(ErrorCode errorCode, String customMessage) {
        this.errorCode = errorCode;
        this.customMessage = customMessage;
    }
}
