package talkwith.semogong.feature.join.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.Builder;
import lombok.Data;
import talkwith.semogong.common.validation.NotBlankGroup;
import talkwith.semogong.common.validation.PatternCheckGroup;
import talkwith.semogong.common.validation.SizeCheckingGroup;

@Data
@Builder
public class JoinRequestDto {

    @NotBlank(groups = NotBlankGroup.class, message = "이름은 공백이 될 수 없습니다.")
    @Size(min = 2, max=6, groups = SizeCheckingGroup.class, message = "이름은 2자 이상 6자 이하여야 합니다.")
    private String name;

    @NotBlank(groups = NotBlankGroup.class, message = "비밀번호는 공백이 될 수 없습니다.")
    @Size(min = 4, max=12, groups = SizeCheckingGroup.class, message = "비밀번호는 4자 이상 12자 이하여야 합니다.")
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d).+$" , groups = PatternCheckGroup.class, message = "비밀번호는 영문자, 숫자를 적어도 하나씩 포함해야 합니다.")
    private String password;

    private int age;
}
