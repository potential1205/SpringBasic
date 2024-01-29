package talkwith.semogong.feature.join.dto.validation;

import jakarta.validation.GroupSequence;
import talkwith.semogong.common.validation.*;

@GroupSequence({NotBlankEmail.class, PatternCheckEmail.class, NotBlankName.class, SizeCheckName.class , NotBlankPassword.class, SizeCheckPassword.class, PatternCheckPassword.class})
public interface JoinRequestDtoValidationSequence {
}
