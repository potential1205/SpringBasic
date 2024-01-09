package talkwith.semogong.feature.search.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchUserRequestDto {
    private String name;
}
