package talkwith.semogong.feature.search.exception;

import lombok.Getter;
import talkwith.semogong.common.enums.ExceptionInfo;
import talkwith.semogong.common.exception.BusinessException;

@Getter
public class NotExistsUserByName extends BusinessException {

    public NotExistsUserByName(ExceptionInfo exceptionInfo, String message) {
        super(exceptionInfo, message);
    }

}
