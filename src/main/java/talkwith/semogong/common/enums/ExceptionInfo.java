package talkwith.semogong.common.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
@Getter
@RequiredArgsConstructor
public enum ExceptionInfo {

    PARAMETER_VALID_FAIL(HttpStatus.BAD_REQUEST, 2201, "파라미터 값이 조건에 맞지 않습니다."),
    RESOURCE_FOUND_FAIL(HttpStatus.NOT_FOUND,2202,"일치하는 리소스가 존재하지 않습니다."),
    RESOURCE_CONFLICT(HttpStatus.CONFLICT, 2203, "이미 존재하는 리소스입니다."),
    SEVER_NOT_SUPPORT(HttpStatus.INTERNAL_SERVER_ERROR,4444,"처리할 수 없는 예외입니다.");

    private final HttpStatus httpStatus;
    private final int code;
    private final String message;
}
