package talkwith.semogong.feature.login.dto.validation;

import jakarta.validation.GroupSequence;
import talkwith.semogong.common.validation.*;

@GroupSequence({NotBlankEmail.class, PatternCheckEmail.class , NotBlankPassword.class, SizeCheckPassword.class, PatternCheckPassword.class})
public interface LoginValidationSequence {
}
