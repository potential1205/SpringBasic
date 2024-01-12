package talkwith.semogong.feature.join.validation;

import jakarta.validation.GroupSequence;


@GroupSequence({NotBlankName.class, SizeCheckingName.class , NotBlankPassword.class, SizeCheckingPassword.class, PatternCheckPassword.class})
public interface JoinValidationSequence {
}
