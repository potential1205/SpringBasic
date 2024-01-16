package talkwith.semogong.common.dto.Response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SuccessResponse {

    private boolean success;

    public static SuccessResponse of() {
        return SuccessResponse.builder()
                .success(true)
                .build();
    }
}
