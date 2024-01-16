package talkwith.semogong.feature.search.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import talkwith.semogong.common.dto.Response.FailResponse;
import talkwith.semogong.common.enums.ExceptionInfo;

import java.util.Optional;

@RestControllerAdvice(basePackages = "talkwith.semogong.feature.search")
public class SearchExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<FailResponse> MethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ExceptionInfo exceptionInfo = ExceptionInfo.PARAMETER_VALID_FAIL;

        BindingResult bindingResult = exception.getBindingResult();
        Optional<FieldError> fieldError = Optional.ofNullable(bindingResult.getFieldError());

        if (fieldError.isEmpty()){
            throw new RuntimeException();
        }

        String exceptionMessage = fieldError.get().getDefaultMessage();

        return ResponseEntity.status(exceptionInfo.getHttpStatus())
                .body(FailResponse.of(exceptionMessage, exceptionInfo.getCode()));
    }

    @ExceptionHandler({NotExistsUserByName.class})
    protected ResponseEntity<FailResponse> handleNotExistsUserByName(NotExistsUserByName exception){
        ExceptionInfo exceptionInfo = exception.getExceptionInfo();
        String exceptionMessage = exception.getCustomMessage();

        return ResponseEntity
                .status(exceptionInfo.getHttpStatus())
                .body(FailResponse.of(exceptionMessage, exceptionInfo.getCode()));
    }
}
