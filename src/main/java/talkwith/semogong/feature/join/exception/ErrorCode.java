package talkwith.semogong.feature.join.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    PARAMETER_VALID_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, 2201, "잘못된 파라미터 값을 넣었습니다."),
    USER_COMMON_FAIL(HttpStatus.INTERNAL_SERVER_ERROR, 2202, "회원 오류입니다.");

    private final HttpStatus statusCode;
    private final int code;
    private final String message;
}
