package talkwith.semogong.feature.join.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import talkwith.semogong.common.dto.ResponseDto;

@RestControllerAdvice(basePackages = "talkwith.semogong.feature.join")
public class JoinExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseDto> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        String message = bindingResult.getFieldError().getDefaultMessage();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ResponseDto(message));
    }

    @ExceptionHandler({DuplicateNameException.class})
    protected ResponseEntity<ResponseDto> handleDuplicateNameException(DuplicateNameException ex){
        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(new ResponseDto(ex.getMessage()));
    }
}