package talkwith.semogong.feature.search.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import talkwith.semogong.common.enums.Rank;
import talkwith.semogong.domain.UserEntity;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchUserResponseDto {
    private String name;
    private Rank rank;
    private int age;

    public SearchUserResponseDto(UserEntity userEntity){
        this.name = userEntity.getName();
        this.rank = userEntity.getRank();
        this.age = userEntity.getAge();
    }

}
