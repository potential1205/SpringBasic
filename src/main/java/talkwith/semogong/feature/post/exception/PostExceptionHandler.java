package talkwith.semogong.feature.post.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import talkwith.semogong.common.dto.Response.FailResponse;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.common.exception.AuthenticationFailException;
import talkwith.semogong.common.exception.ResourceNotFoundException;

@RestControllerAdvice(basePackages = "talkwith.semogong.feature.post")
public class PostExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    protected ResponseEntity<FailResponse> handleNotExistsUserByName(ResourceNotFoundException exception){
        ExceptionInfo exceptionInfo = exception.getExceptionInfo();
        String exceptionMessage = exception.getCustomMessage();

        return ResponseEntity
                .status(exceptionInfo.getHttpStatus())
                .body(FailResponse.of(exceptionMessage, exceptionInfo.getCode()));
    }

    @ExceptionHandler({AuthenticationFailException.class})
    protected ResponseEntity<FailResponse> handleNotAuthorizeException(AuthenticationFailException exception){
        ExceptionInfo exceptionInfo = exception.getExceptionInfo();
        String exceptionMessage = exception.getCustomMessage();

        return ResponseEntity
                .status(exceptionInfo.getHttpStatus())
                .body(FailResponse.of(exceptionMessage, exceptionInfo.getCode()));
    }

}
