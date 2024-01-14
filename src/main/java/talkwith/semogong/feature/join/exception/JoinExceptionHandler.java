package talkwith.semogong.feature.join.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice(basePackages = "talkwith.semogong.feature.join")
public class JoinExceptionHandler {

    @ExceptionHandler({DuplicateNameException.class})
    protected ResponseEntity<ErrorResponse> handleDuplicateNameException(DuplicateNameException exception){
        ErrorCode errorCode = exception.getErrorCode();

        return ResponseEntity.status(errorCode.getStatusCode())
                .body(ErrorResponse.of(errorCode, exception.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ErrorCode errorCode = ErrorCode.PARAMETER_VALID_FAIL;

        BindingResult bindingResult = exception.getBindingResult();
        String message = Optional.ofNullable(bindingResult.getFieldError())
                .orElseThrow(IllegalArgumentException::new)
                .getDefaultMessage();

        return ResponseEntity
                .status(errorCode.getStatusCode())
                .body(ErrorResponse.of(errorCode, message));
    }
}