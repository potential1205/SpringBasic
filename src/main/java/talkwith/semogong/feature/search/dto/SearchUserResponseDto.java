package talkwith.semogong.feature.search.dto;

import lombok.Builder;
import lombok.Data;
import talkwith.semogong.common.enums.Rank;

@Data
@Builder
public class SearchUserResponseDto {
    private String name;
    private Rank rank;
    private int age;
}
