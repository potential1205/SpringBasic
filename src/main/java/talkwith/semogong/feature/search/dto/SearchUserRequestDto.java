package talkwith.semogong.feature.search.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import talkwith.semogong.feature.join.validation.NotBlankName;
import talkwith.semogong.feature.join.validation.SizeCheckingName;

@Data
@Builder
public class SearchUserRequestDto {
    @NotBlank(message = "이름은 공백이 될 수 없습니다.", groups = NotBlankName.class)
    @Size(min = 2, max=6, message = "이름은 2자 이상 6자 이하여야 합니다.", groups = SizeCheckingName.class)
    private String name;
}
