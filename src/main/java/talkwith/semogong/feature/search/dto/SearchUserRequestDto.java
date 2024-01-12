package talkwith.semogong.feature.search.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchUserRequestDto {
    @NotBlank
    private String name;
}
