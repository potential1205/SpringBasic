package talkwith.semogong.feature.search.exception;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import talkwith.semogong.common.dto.ResponseDto;

@RestControllerAdvice(basePackages = "talkwith.semogong.feature.search")
public class SearchExceptionHandler {

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ResponseDto> MethodArgumentNotValidException(MethodArgumentNotValidException ex){
        return new ResponseEntity<>(new ResponseDto(ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({NotExistsUserByName.class})
    protected ResponseEntity<ResponseDto> handleNotExistsUserByName(NotExistsUserByName ex){
        return new ResponseEntity<>(new ResponseDto(ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }
}
