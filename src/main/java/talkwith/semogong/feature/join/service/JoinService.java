package talkwith.semogong.feature.join.service;

import talkwith.semogong.common.exception.ResourceConflictException;
import talkwith.semogong.feature.join.dto.JoinCodeRequestDto;
import talkwith.semogong.feature.join.dto.JoinEmailRequestDto;
import talkwith.semogong.feature.join.dto.JoinFormRequestDto;

public interface JoinService {

    void checkDuplicateByJoinFormProcess(JoinFormRequestDto joinFormRequestDto) throws ResourceConflictException;
    void sendCodeToEmailProcess(JoinEmailRequestDto joinEmailRequestDto);

    void checkCodeProcess(JoinCodeRequestDto joinCodeRequestDto);

}
