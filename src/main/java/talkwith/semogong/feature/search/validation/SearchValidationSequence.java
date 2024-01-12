package talkwith.semogong.feature.search.validation;

import jakarta.validation.GroupSequence;
import talkwith.semogong.feature.join.validation.NotBlankName;
import talkwith.semogong.feature.join.validation.SizeCheckingName;

@GroupSequence({NotBlankName.class, SizeCheckingName.class})
public interface SearchValidationSequence {
}
