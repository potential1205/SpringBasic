package talkwith.semogong.feature.join.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class JoinCodeRequestDto {
    private String email;
    private String name;
    private String password;
    private String code;
}
