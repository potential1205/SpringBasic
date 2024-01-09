package talkwith.semogong.common.validation;

import jakarta.validation.GroupSequence;


@GroupSequence({NotBlankGroup.class, SizeCheckingGroup.class ,PatternCheckGroup.class})
public interface ValidationSequence {
}
