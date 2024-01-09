package talkwith.semogong.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import talkwith.semogong.common.dto.ResponseDto;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ResponseDto> handleCustomException(Exception ex){
        return new ResponseEntity<>(new ResponseDto("이미 존재하는 회원 이름입니다."), new HttpHeaders(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ResponseDto> handleValidationExceptions(MethodArgumentNotValidException ex){
        BindingResult bindingResult = ex.getBindingResult();
        String message = bindingResult.getFieldError().getDefaultMessage();

        return new ResponseEntity<>(new ResponseDto(message), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}